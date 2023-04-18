package com.erphotel;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;

@Controller
public class MainController {

    @GetMapping ("/testing")
    public String testingScreen(){
        return "testing";
    }
    @GetMapping("/")
    public String loginScreen(Model model, @AuthenticationPrincipal User username) {
        return "home";
    }

    @GetMapping("/home")
    public String home(Model model, @AuthenticationPrincipal User username) {
        return "home";
    }
    
    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        return "dashboard";
    }
    
}