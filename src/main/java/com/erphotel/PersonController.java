    package com.erphotel;

    import org.springframework.ui.Model;
    import com.erphotel.personManagement.domain.PersonDomain;
    import com.erphotel.personManagement.service.PersonService;
    import java.util.List;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Controller;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.ModelAttribute;
    import org.springframework.web.bind.annotation.PathVariable;
    import org.springframework.web.bind.annotation.PostMapping;

    @Controller
    public class PersonController {

        @Autowired
        private PersonService personService;

        @GetMapping({"/Person", "/person", "/personas", "/persona"})
        public String listPerson(Model model) {

            List<PersonDomain> personas = personService.listPersonas();
            model.addAttribute("personas", personas);

            return "person";
        }

        @GetMapping("/person/new")
        public String mostrarFormularioDeRegistrtarPersona(Model modelo) {
            PersonDomain persona = new PersonDomain();
            modelo.addAttribute("persona", persona);
            return "newPerson";
        }

        @PostMapping("/savePersona")
        public String guardarPersona(@ModelAttribute("persona") PersonDomain persona) {
            personService.salvar(persona);
            return "redirect:/persona";
        }

        @GetMapping("/person/{id}")
        public String eliminarPerson(PersonDomain persona) {
            personService.borrar(persona);
            return "redirect:/person";
        }

        @GetMapping("/person/editPerson/{id}")
        public String cambiarPersona(PersonDomain persona, Model model) {
            persona = personService.localizarPersona(persona);
            model.addAttribute("persona", persona);
            return "editPerson";
        }
    }
