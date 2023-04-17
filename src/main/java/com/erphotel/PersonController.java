package com.erphotel;

import com.erphotel.AuthSecurity.controller.EmployeeService;
import com.erphotel.AuthSecurity.controller.RolService;
import com.erphotel.AuthSecurity.domain.LoginDomain;
import com.erphotel.AuthSecurity.domain.RolDomain;
import org.springframework.ui.Model;
import com.erphotel.personManagement.domain.PersonDomain;
import com.erphotel.personManagement.service.PersonService;
import jakarta.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class PersonController {

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private PersonService personService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private RolService rolService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping({"/Person", "/person", "/personas", "/persona"})
    public String listPerson(Model model, @AuthenticationPrincipal User username) {
        List<PersonDomain> personas = personService.listPersonas();
        model.addAttribute("personas", personas);
        return "person";
    }

    @GetMapping("/person/new")
    public String mostrarFormularioDeRegistrtarPersona(Model modelo, @AuthenticationPrincipal User username) {
        PersonDomain persona = new PersonDomain();
        modelo.addAttribute("persona", persona);
        return "newPerson";
    }

    @GetMapping("/employee/new")
    public String mostrarFormularioDeRegistrtarTrabajador(Model modelo, @AuthenticationPrincipal User username) {
        List<PersonDomain> personas = personService.listPersonas();
        List<LoginDomain> employessList = employeeService.listEmployee();
        List<RolDomain> rols = rolService.listDistinctRols();
        personas.removeIf(p -> employessList.stream().anyMatch(e -> e.getEmployee_id() == p.getPerson_id()));
        LoginDomain employee = new LoginDomain();
        modelo.addAttribute("personas", personas);
        modelo.addAttribute("rols", rols);
        modelo.addAttribute("employee", employee);
        modelo.addAttribute("employessList", employessList);
        return "newEmployee";
    }

    @Validated
    @PostMapping("/actualizarPersona/{person_id}")
    public String actualizarPersona(@Valid @ModelAttribute("persona") PersonDomain persona, BindingResult result
    ) {
        if (result.hasErrors()) {
            return "editPerson";
        }
        personService.salvar(persona);
        return "redirect:/persona";
    }

    @GetMapping("/person/{person_id}")
    public String eliminarPerson(PersonDomain persona, @AuthenticationPrincipal User username) {
        LoginDomain employee = (LoginDomain) employeeService.findEmployeeById(persona.getPerson_id());
        if (employee == null) {
            personService.borrar(persona);
        } else if (username.getUsername().equals(employee.getUsername())) {
            return "redirect:/person";
        } else {
            for (RolDomain rol : employee.getRols()) {
                rolService.borrar(rol.getId());
            }
            employee.getRols().clear();
            employeeService.borrar(employee);
            personService.borrar(persona);
        }
        return "redirect:/person";
    }

    @GetMapping("/person/editPerson/{person_id}")
    public String cambiarPersona(PersonDomain persona, Model model,
            @AuthenticationPrincipal User username
    ) {
        persona = personService.localizarPersona(persona);
        model.addAttribute("persona", persona);
        return "editPerson";
    }

    @Validated
    @PostMapping("/savePersona")
    public String guardarPersona(@Valid @ModelAttribute("persona") PersonDomain persona, BindingResult result) {
        if (result.hasErrors()) {
            return "newPerson";
        }
        personService.salvar(persona);
        return "redirect:/person";
    }

    @PostMapping("/saveEmployee")
    public String guardarEmployee(@ModelAttribute("employee") LoginDomain employee, @AuthenticationPrincipal User username
    ) {
        if (!username.getUsername().equals(employee.getUsername())) {
            LoginDomain newEmployee = new LoginDomain();
            newEmployee.setEmployee_id(employee.getEmployee_id());
            newEmployee.setContract_start(employee.getContract_start());
            newEmployee.setUsername(employee.getUsername());
            newEmployee.setPassword(passwordEncoder.encode(employee.getPassword()));
            employeeService.salvar(newEmployee);
            for (RolDomain rol : employee.getRols()) {
                RolDomain rolDomain = new RolDomain();
                rolDomain.setId_rol(rol.getId_rol());
                rolDomain.setName(rol.getName());
                newEmployee.getRols().add(rolDomain);
                rolService.guardarRol(rolDomain.getId_rol(), rolDomain.getName(), employee.getEmployee_id());
            }
        }
        return "redirect:/person";
    }

}
