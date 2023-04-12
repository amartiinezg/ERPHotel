package com.erphotel.Booking.domain;

import java.io.Serializable;

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
    private String check_in;
    private String check_out;
    private Integer number_people;
    private Integer room_id;
    private Integer room_number;
}

