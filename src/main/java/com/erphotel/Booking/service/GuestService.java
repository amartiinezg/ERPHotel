package com.erphotel.Booking.service;

import java.util.List;

import com.erphotel.Booking.domain.Guest;

public interface GuestService {
    public List<Guest> listGuests();
    public void save(Guest guest);
    public void delete(Guest guest);
    public Guest findGuest(Guest guest);
}
