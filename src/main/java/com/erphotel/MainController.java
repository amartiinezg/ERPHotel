package com.erphotel;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;

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