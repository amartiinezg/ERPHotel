package com.erphotel.tests;

import com.erphotel.personManagement.domain.PersonDomain;
import com.erphotel.personManagement.service.PersonServiceImplemented;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.api.Order;
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
    String number = "651232425";
    String dni = "47929975A";
    String newName = "Pepe";
    @BeforeEach
    void setUp() {
        personDomain.setName(name);
        personDomain.setSurname(surname);
        personDomain.setPhone_number(number);
        personDomain.setDni(dni);


    }

  @Order(1)
    @DisplayName("Junit test for add Persona object")
    @Test
    public void testA(){
        personServiceImplemented.salvar(personDomain);
       Assertions.assertThat(personServiceImplemented.localizarPersona(personDomain)).isNotNull();
    }

@Order(2)
    @DisplayName("Junit test for modify Person")
    @Test
    public void testB(){
        personDomain = personServiceImplemented.findPersonByName(name).get(0);
        personDomain.setName(newName);
        personServiceImplemented.salvar(personDomain);
        Assertions.assertThat(personServiceImplemented.localizarPersona(personDomain)).isNotNull();
    }
    @Order(3)
    @DisplayName("Junit test for delete Persona Object")
    @Test
    public void testC(){
        personDomain = personServiceImplemented.findPersonByName(newName).get(0);
        personServiceImplemented.borrar(personDomain);
        Assertions.assertThat(personServiceImplemented.localizarPersona(personDomain)).isNull();
    }
}