package com.erphotel;

import org.springframework.ui.Model;
import com.erphotel.personManagement.domain.PersonDomain;
import com.erphotel.personManagement.service.PersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class PersonController {

    @Autowired
    private PersonService personaServicio;

    @GetMapping({"/Person", "/person", "/personas", "/persona"})
    public String listPerson(Model model) {

        List<PersonDomain> personas = personaServicio.listPersonas();
        model.addAttribute("personas", personas);

        return "person";
    }

}
