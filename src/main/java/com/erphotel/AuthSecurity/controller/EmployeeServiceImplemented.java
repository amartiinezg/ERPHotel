/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erphotel.AuthSecurity.controller;

import com.erphotel.AuthSecurity.dao.LoginDAO;
import com.erphotel.AuthSecurity.domain.LoginDomain;
import com.erphotel.AuthSecurity.domain.RolDomain;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alex
 */
@Service
public class EmployeeServiceImplemented implements EmployeeService {

    @Autowired
    private LoginDAO loginDAO;

    @Override
    public List<LoginDomain> listEmployee() {
        return (List<LoginDomain>) loginDAO.findAll();
    }

    @Override
    public void salvar(LoginDomain employee) {
        loginDAO.save(employee);
    }

    @Override
    public void borrar(LoginDomain employee) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public LoginDomain localizarEmployee(LoginDomain employee) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<LoginDomain> findEmployeeByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
