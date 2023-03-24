package com.erphotel.Login.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration //Indica al sistema que és una classe de configuració
@EnableWebSecurity //Habilita la seguretat web
@Slf4j
public class ConfigurationAutentificator {

    @Autowired
    private UserDetailsService userDetailsService; //Objecte per recuperar l'usuari

    /*AUTENTICACIÓ*/
 /*Injectem mitjançant @Autowired, els mètodes de la classe AuthenticationManagerBuilder. Mitjançant
     *aquesta classe cridarem al mètode userDetailsService de la classe AuthenticationManagerBuilder què és el mètode que
     *realitzarà l'autenticació. Per parm̀etre el sistema li passa l'usuari introduit en el formulari d'autenticació.
     *Aquest usuari ens el retorna el mètode loadUserByUsername implementat en UsuariService.
     *
     *Cridem al mètode passwordEncoder passant-li com a paràmetre un objecte de tipus BCryptPasswordEncoder()
     *per encriptar el password introduït per l'usuari en el moment d'autenticar-se i comparar-lo
     *amb l'encriptació del password guardat a la BBDD corresponent a l'username introduït també en l'autenticació.
     */
    @Autowired
    public void autenticacio(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
    String[] staticResources = {
        "/css/**",
        "/images/**",
        "/fonts/**",
        "/scripts/**"};

    //L'indica al sistema que el mètode és un Bean, en aquest cas perquè crea un objecte de la classe HttpSecurity
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http.authorizeHttpRequests((requests) -> requests
                .requestMatchers(staticResources).permitAll()
                .requestMatchers("/person/**", "/room/**", "/hotel_booking", "/home/**").hasAnyAuthority("staff", "recepcio")
                .anyRequest().authenticated())
                .formLogin((form) -> form.loginPage("/login").permitAll())
                .exceptionHandling((exception) -> exception.accessDeniedPage("/errors/error403"))
                .build();
    }
}
