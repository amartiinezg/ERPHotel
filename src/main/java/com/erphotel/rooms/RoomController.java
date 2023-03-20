/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erphotel.rooms;

import com.erphotel.rooms.domain.Room;
import com.erphotel.rooms.services.RoomService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author alejandro
 */
@Controller
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping("/room")
    public String mainRoom(Model model) {
        List<Room> roomList = roomService.roomList();
        System.out.println(roomList.get(0).toString());
        model.addAttribute("roomList", roomList);
        
        
        return "rooms";

    }

}
