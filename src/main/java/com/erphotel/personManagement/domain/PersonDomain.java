package com.erphotel.personManagement.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "persons")
public class PersonDomain implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long person_id;
    private String name;
    private String surname;
    private String phone_number;
    private String dni;
}
