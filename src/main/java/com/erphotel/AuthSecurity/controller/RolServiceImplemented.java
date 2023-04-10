/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erphotel.AuthSecurity.controller;

import com.erphotel.AuthSecurity.dao.RolDAO;
import com.erphotel.AuthSecurity.domain.RolDomain;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alex
 */
@Service
public class RolServiceImplemented implements RolService {

    @Autowired
    private RolDAO rolDAO;

    @Override
    public List<RolDomain> listRols() {
    return (List<RolDomain>) rolDAO.findAll();
    }

}
