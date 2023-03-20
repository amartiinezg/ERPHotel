/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erphotel.rooms.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;

/**
 *
 * @author alejandro
 */
@Entity
@Table(name = "rooms")
public class Room implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long room_id;

    private int room_number;
    
    private String room_type;

    private boolean status;

    private float price;

    private boolean is_clean;

    private boolean safe;
    
    public Room() {
        
    }

    public Room(long room_id, int room_number, String room_type, boolean status, float price, boolean is_clean, boolean safe) {
        this.room_id = room_id;
        this.room_number = room_number;
        this.room_type = room_type;
        this.status = true;
        this.price = price;
        this.is_clean = true;
        this.safe = false;
    }
    
    //Getters and setters
    public long getRoom_id() {
        return room_id;
    }

    public int getRoom_number() {
        return room_number;
    }

    public String getRoom_type() {
        return room_type;
    }

    public boolean isStatus() {
        return status;
    }

    public float getPrice() {
        return price;
    }

    public boolean isIs_clean() {
        return is_clean;
    }

    public boolean isSafe() {
        return safe;
    }

    public void setRoom_id(long room_id) {
        this.room_id = room_id;
    }

    public void setRoom_number(int room_number) {
        this.room_number = room_number;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setIs_clean(boolean is_clean) {
        this.is_clean = is_clean;
    }

    public void setSafe(boolean safe) {
        this.safe = safe;
    }
    
}
