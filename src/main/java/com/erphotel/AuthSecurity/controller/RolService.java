/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erphotel.AuthSecurity.controller;

import com.erphotel.AuthSecurity.domain.RolDomain;
import java.util.List;

/**
 *
 * @author Alex
 */
public interface RolService {

    public List<RolDomain> listRols();

    public void salvar(RolDomain rol);

    public void guardarRol(long id_rol, String name, long employee_id);
    
   public List<RolDomain> listDistinctRols();
}
