package com.erphotel.Login.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ConfigurationIdentification implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry register) {
        register.addViewController("/").setViewName("index");
        register.addViewController("/login");
        register.addViewController("/errors/error403").setViewName("/errors/error403");
    }
}
