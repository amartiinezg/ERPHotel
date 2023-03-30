package com.erphotel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.erphotel.personManagement.domain.PersonDomain;
import com.erphotel.personManagement.service.PersonService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {

    @Autowired
    private PersonService personService;

    @GetMapping("/")
    public String loginScreen() {
        return "person";
    }

    @GetMapping("/hotel_booking")
    public String bookingWidget(Model model) {
        List<PersonDomain> personas = personService.listPersonas();
        for (PersonDomain person : personas) {
            System.out.println(person.toString());
        }
        model.addAttribute("personas", personas);
        return "hotel_booking";
    }

    @GetMapping("/home")
    public String home(Model model) {
            return "person";
    }
}