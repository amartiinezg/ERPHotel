package com.erphotel.personManagement.service;

import com.erphotel.Login.domain.LoginDomain;
import com.erphotel.personManagement.dao.PersonDAO;
import com.erphotel.personManagement.domain.PersonDomain;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;


public class PersonServiceImplemented implements PersonService {

    @Autowired
    private PersonDAO personaDAO;

    @Override
    public List<PersonDomain> listPersonas() {
        return (List<PersonDomain>) personaDAO.findAll();
    }

    @Override
    public void salvar(PersonDomain persona) {
        personaDAO.save(persona);
    }

    @Override
    public void borrar(PersonDomain persona) {
        personaDAO.delete(persona);
    }

    @Override
    public PersonDomain localizarPersona(PersonDomain persona) {
      return personaDAO.findById(persona.getId()).orElse(null);
    }
}
