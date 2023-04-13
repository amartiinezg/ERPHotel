package com.erphotel.Booking.domain;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "guests")
public class Guest implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long guest_id;
    private String board;
    private Integer person_id;

    // Setters
    public void setGuest_id(Long guest_id) {
        this.guest_id = guest_id;
    }

    public void setBoard(String board) {
        this.board = board;
    }

    public void setPerson_id(Integer person_id) {
        this.person_id = person_id;
    }

    // Getters
    public Long getGuest_id() {
        return guest_id;
    }

    public String getBoard() {
        return board;
    }

    public Integer getPerson_id() {
        return person_id;
    }
}
