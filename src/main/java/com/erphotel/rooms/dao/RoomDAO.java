/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erphotel.rooms.dao;

import com.erphotel.rooms.domain.Room;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author alejandro
 */
public interface RoomDAO extends CrudRepository<Room, Long>{
    
}
