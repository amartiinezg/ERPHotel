package com.erphotel.Booking.dao;

import org.springframework.data.repository.CrudRepository;
import com.erphotel.Booking.domain.Guest;

public interface GuestDAO extends CrudRepository<Guest, Long> {
    
}
