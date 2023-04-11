package com.erphotel.Booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.erphotel.Booking.dao.GuestDAO;
import com.erphotel.Booking.domain.Guest;

@Service
public class GuestServiceImplement implements GuestService {
    @Autowired
    private GuestDAO guestDAO;

    @Override
    @Transactional(readOnly = true)
    public List<Guest> listGuests() {
        return (List<Guest>) guestDAO.findAll();
    }

    @Override
    @Transactional
    public void save(Guest guest) {
        guestDAO.save(guest);
    }

    @Override
    @Transactional
    public void delete(Guest guest) {
        guestDAO.delete(guest);
    }

    @Override
    @Transactional(readOnly = true)
    public Guest findGuest(Guest guest) {
        return guestDAO.findById(guest.getGuest_id()).orElse(null);
    }
}
