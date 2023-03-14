/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erphotel.rooms.services;

import com.erphotel.rooms.dao.RoomDAO;
import com.erphotel.rooms.domain.Room;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author alejandro
 */
public class RoomServiceImpl implements RoomService{
    
    @Autowired
    private RoomDAO roomDAO;

    @Override
    @Transactional(readOnly = true)
    public List<Room> roomList() {
        return (List<Room>)roomDAO.findAll();
    }

    @Override
    @Transactional
    public void save(Room room) {
        roomDAO.save(room);
    }

    @Override
    @Transactional
    public void delete(Room room) {
        roomDAO.delete(room);
    }

    @Override
    @Transactional
    public Room getRoom(Room room) {
        return roomDAO.findById(room.getRoomId()).orElse(null);
    }
    
}
