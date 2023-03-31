package com.erphotel.personManagement.service;

import com.erphotel.personManagement.domain.PersonDomain;

import java.util.List;

public interface PersonService {
    public List<PersonDomain> listPersonas();

    public void salvar(PersonDomain persona);

    public void borrar (PersonDomain persona);

    public PersonDomain localizarPersona (PersonDomain persona);

  public List<PersonDomain> findPersonByName(String name);
}
