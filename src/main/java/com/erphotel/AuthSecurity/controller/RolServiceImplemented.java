/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erphotel.AuthSecurity.controller;

import com.erphotel.AuthSecurity.dao.RolDAO;
import com.erphotel.AuthSecurity.domain.RolDomain;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Alex
 */
@Service
public class RolServiceImplemented implements RolService {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private RolDAO rolDAO;

    @Override
    public List<RolDomain> listRols() {
        return (List<RolDomain>) rolDAO.findAll();
    }

    @Transactional
    @Override
    public void guardarRol(long id_rol, String name, long employee_id) {
        String query = "INSERT INTO rols (id_rol, name, employee_id) VALUES (:id_rol, :name, :employee_id)";
        em.createNativeQuery(query)
                .setParameter("id_rol", id_rol)
                .setParameter("name", name)
                .setParameter("employee_id", employee_id)
                .executeUpdate();
    }

    @Override
    public void salvar(RolDomain rol) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Transactional
    @Override
    public List<RolDomain> listDistinctRols() {
        return rolDAO.findDistinctRols();
    }
}
