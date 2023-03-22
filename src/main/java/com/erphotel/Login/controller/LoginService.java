package com.erphotel.Login.controller;

import java.util.ArrayList;

import com.erphotel.Login.dao.LoginDAO;
import com.erphotel.Login.domain.LoginDomain;
import com.erphotel.Login.domain.RolDomain;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service ("userDetailsService")
@Slf4j
public class LoginService implements UserDetailsService{

    @Autowired
    private LoginDAO loginDAO;

    @Override
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        LoginDomain loginDomain = loginDAO.findByUsername(username);

        if(loginDomain==null){

            throw new UsernameNotFoundException(username);

        }

        var rols= new ArrayList<GrantedAuthority>();

        for(RolDomain rol: loginDomain.getRols()){
            rols.add(new SimpleGrantedAuthority(rol.getName()));
        }

        log.info(loginDomain.getUsername());
        log.info(loginDomain.getPassword());
        log.info(rols.get(0).getAuthority());

        return new User(loginDomain.getUsername(), loginDomain.getPassword(), rols);
    }
}
