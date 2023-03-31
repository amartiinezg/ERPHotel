package com.erphotel.tests;

import com.erphotel.personManagement.domain.PersonDomain;
import com.erphotel.personManagement.service.PersonServiceImplemented;

import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class TestCRUDPersonaTest {
    @Autowired
    PersonServiceImplemented personServiceImplemented;

    PersonDomain personDomain = new PersonDomain();
    String name = "Adam";
    String surname = "Sánchez";
    String number = "622451059";
    String dni = "47929975E";
    @BeforeEach
    void setUp() {
        personDomain.setName(name);
        personDomain.setSurname(surname);
        personDomain.setPhone_number(number);
        personDomain.setDni(dni);


    }

    @DisplayName("Junit test for add Persona object")
    @Test
    public void addPersona(){
        personServiceImplemented.salvar(personDomain);
       Assertions.assertThat(personServiceImplemented.localizarPersona(personDomain)).isNotNull();
    }

    @DisplayName("Junit test for delete Persona Object")
    @Test
    public void deletePersona(){
        personDomain = personServiceImplemented.findPersonByName(name).get(0);
        personServiceImplemented.borrar(personDomain);
        Assertions.assertThat(personServiceImplemented.localizarPersona(personDomain)).isNull();
    }
}