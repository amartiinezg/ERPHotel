package com.erphotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
    private final String USERNAME = "admin";
    private final String PASSWORD = "wipe";

    @Autowired

    @GetMapping("/")
    public String loginScreen() {
        return "indice";
    }

    @GetMapping("/home")
    public String home(HttpSession session) {
        if (session.getAttribute("loggedIn") != null && (Boolean) session.getAttribute("loggedIn")) {
            return "home";
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session) {
        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            session.setAttribute("loggedIn", true);
            return "redirect:/home";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping ("/MakeInvoice")
    public static String makeInvoice(){
        return "invoice";
    }

    @GetMapping ("/testing")
    public static String testing(){
        return "newInvoiceLineForm";
    }

}
