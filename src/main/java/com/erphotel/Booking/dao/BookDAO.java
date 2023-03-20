package com.erphotel.Booking.dao;

import org.springframework.data.repository.CrudRepository;
import com.erphotel.Booking.domain.Book;

public interface BookDAO extends CrudRepository<Book, Long> {
}
