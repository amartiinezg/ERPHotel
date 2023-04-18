package com.erphotel.AuthSecurity.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ConfigurationAutentificator {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    public void autenticacio(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    String[] staticResources = {
        "/css/**",
        "/images/**",
        "/fonts/**",
        "/scripts/**",
        "/error/**",
        "/static/**",
        "/language/**"
    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .headers().frameOptions().disable()
                .and()
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers(staticResources).permitAll()
                        .requestMatchers("/", "home", "/home/**","/dashboard/**", "/person/**", "/savePersona", "/homeScript.js", "/invoiceManager/**", "/invoice/**", "/invoiceLines/**", "/assets/**", "/homeStyle.css", "/error/**", "/functions/**", "/rooms/**", "/hotel_booking/**", "/booking/**").hasAnyAuthority("recepcion", "limpieza", "staff")
                        .requestMatchers("/**").hasAnyAuthority("staff")
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                .loginPage("/login")
                .permitAll()
                )
                .logout((logout) -> logout.
                permitAll()
                )
                .exceptionHandling((exception) -> exception
                .accessDeniedPage("/error/error403")
                )
                .build();
    }


    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
