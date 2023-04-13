package com.erphotel;

import com.erphotel.personManagement.domain.PersonDomain;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;

import java.util.List;

@Controller
public class MainController {

    @GetMapping("/")
    public String loginScreen(Model model, @AuthenticationPrincipal User username) {
        return "home";
    }

    @GetMapping("/hotel_booking")
    public String bookingWidget(Model model, @AuthenticationPrincipal User username) {
        List<PersonDomain> personas = personService.listPersonas();
        for (PersonDomain person : personas) {
            System.out.println(person.toString());
        }
        model.addAttribute("personas", personas);
        return "hotel_booking";
    }

    @GetMapping("/home")
    public String home(Model model, @AuthenticationPrincipal User username) {
        return "home";
    }
}