package com.erphotel.Login.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table (name = "personas")
public class LoginDomain {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String dni;
}
