package com.erphotel.Booking.domain;

import java.io.Serializable;

import com.erphotel.rooms.domain.Room;

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
    
    @OneToOne
    @JoinColumn(name = "room_id")
    private Room room;

}

