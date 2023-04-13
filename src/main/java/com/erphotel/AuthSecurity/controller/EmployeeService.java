/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.erphotel.AuthSecurity.controller;
import com.erphotel.AuthSecurity.domain.LoginDomain;
import java.util.List;

/**
 *
 * @author Alex
 */
public interface EmployeeService {
    
    public List<LoginDomain> listEmployee();

    public void salvar(LoginDomain employee);

    public void borrar (LoginDomain employee);

    public LoginDomain localizarEmployee (LoginDomain employee);

    public List<LoginDomain> findEmployeeByName(String name);
  
    public LoginDomain findEmployeeById(long id);
  
}
