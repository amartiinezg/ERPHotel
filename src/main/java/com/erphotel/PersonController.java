package com.erphotel;

import com.erphotel.AuthSecurity.controller.EmployeeService;
import com.erphotel.AuthSecurity.controller.RolService;
import com.erphotel.AuthSecurity.domain.LoginDomain;
import com.erphotel.AuthSecurity.domain.RolDomain;
import org.springframework.ui.Model;
import com.erphotel.personManagement.domain.PersonDomain;
import com.erphotel.personManagement.service.PersonService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PersonController {

    @Autowired
    private PersonService personService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private RolService rolService;

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
        List<RolDomain> rols = rolService.listDistinctRols();
        LoginDomain employee = new LoginDomain();
        modelo.addAttribute("personas", personas);
        modelo.addAttribute("rols", rols);
        modelo.addAttribute("employee", employee);
        return "newEmployee";
    }

    @PostMapping("/actualizarPersona/{person_id}")
    public String actualizarPersona(PersonDomain persona, @AuthenticationPrincipal User username) {
        personService.salvar(persona);
        return "redirect:/persona";
    }

    @GetMapping("/person/{person_id}")
    public String eliminarPerson(PersonDomain persona, @AuthenticationPrincipal User username) {
        personService.borrar(persona);
        return "redirect:/person";
    }

    @GetMapping("/person/editPerson/{person_id}")
    public String cambiarPersona(PersonDomain persona, Model model, @AuthenticationPrincipal User username) {
        persona = personService.localizarPersona(persona);
        model.addAttribute("persona", persona);
        return "editPerson";
    }

    @PostMapping("/savePersona")
    public String guardarPersona(@ModelAttribute("persona") PersonDomain persona, @AuthenticationPrincipal User username) {
        personService.salvar(persona);
        return "redirect:/person";
    }

    @PostMapping("/saveEmployee")
    public String guardarEmployee(@ModelAttribute("employee") LoginDomain employee, @AuthenticationPrincipal User username) {
        if (username.getUsername() != employee.getUsername()) {
            LoginDomain newEmployee = new LoginDomain();
            newEmployee.setEmployee_id(employee.getEmployee_id());
            newEmployee.setContract_start(employee.getContract_start());
            newEmployee.setUsername(employee.getUsername());
            newEmployee.setPassword(employee.getPassword());
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
