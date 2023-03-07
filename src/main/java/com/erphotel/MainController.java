package com.erphotel;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping ("/")
    public String loginScreen(){
        return "indice";
    }
}
