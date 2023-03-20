package com.erphotel.Booking.service;

import java.util.List;
import com.erphotel.Booking.domain.Book;

public interface BookService {
    public List<Book> listBooks();
    public void save(Book book);
    public void delete(Book book);
    public Book findBook(Book book);
}
