package com.erphotel;

import com.erphotel.personManagement.domain.PersonDomain;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;

import java.util.List;

@Controller
public class MainController {

    @GetMapping("/")
    public String loginScreen(Model model, @AuthenticationPrincipal User username) {
        return "home";
    }



    @GetMapping("/home")
    public String home(Model model, @AuthenticationPrincipal User username) {
            return "home";
    }
}