package com.erphotel.personManagement.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import java.io.Serializable;
import lombok.Data;


@Data
@Entity
@Table(name = "persons")
public class PersonDomain implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long person_id;
    @NotBlank(message = "El nombre es obligatorio")
    private String name;
    @NotBlank(message = "El apellido es obligatorio")
    private String surname;
    @Pattern(regexp = "^[0-9]{9}$", message = "Por favor, introduce un número de teléfono válido (9 dígitos)")
    private String phone_number;
    @Pattern(regexp = "^[0-9]{8}[A-Za-z]$", message = "Por favor, introduce un DNI válido (8 dígitos y 1 letra)")
    private String dni;
}
