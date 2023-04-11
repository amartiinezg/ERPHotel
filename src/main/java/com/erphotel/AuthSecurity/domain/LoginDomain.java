package com.erphotel.AuthSecurity.domain;

import com.erphotel.personManagement.domain.PersonDomain;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table (name = "employees")
public class LoginDomain implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @Column(name = "employee_id")
    private Long employee_id;
    private String contract_start;
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
    @OneToMany
    @JoinColumn(name="employee_id")
    private List<RolDomain> rols;

}
