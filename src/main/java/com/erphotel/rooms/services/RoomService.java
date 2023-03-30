/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.erphotel.rooms.services;

import com.erphotel.rooms.domain.Room;
import java.util.List;

/**
 *
 * @author alejandro
 */
public interface RoomService {

    public List<Room> roomList();

    public void save(Room room);
    
    public void delete(Room room);
    
    public Room getRoom(Room room);
    
    public List<Room> getByKeyword(String keyword);

}
