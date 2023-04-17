/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erphotel.rooms.dao;

import com.erphotel.rooms.domain.Room;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author alejandro
 */
@Repository
public interface RoomDAO extends JpaRepository<Room, Long>{
    //Custom query
    @Query(value = "select * from rooms s where s.room_number like %:keyword% or s.room_type like %:keyword%", nativeQuery = true)
    List<Room> findByKeyword(@Param("keyword") String keyword);
    
}
