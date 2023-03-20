package com.erphotel.personManagement.service;

import com.erphotel.Login.domain.LoginDomain;
import com.erphotel.personManagement.domain.PersonDomain;

import java.util.List;

public interface PersonService {
    public List<PersonDomain> listPersonas();

    public void salvar(PersonDomain persona);

    public void borrar (PersonDomain persona);

    public PersonDomain localizarPersona (PersonDomain persona);
}
