package com.erphotel.Booking.domain;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="books")
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long book_id;
    private Date check_in;
    private Date check_out;
    private String pay_method;
    private Integer number_people;
    private Integer room_id;
}

