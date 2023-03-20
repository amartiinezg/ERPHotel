package com.erphotel.Booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.erphotel.Booking.dao.BookDAO;
import com.erphotel.Booking.domain.Book;

@Service
public class BookServiceImplement implements BookService {

    @Autowired
    private BookDAO bookDAO;

    @Override
    @Transactional(readOnly = true)
    public List<Book> listBooks() {
        return (List<Book>) bookDAO.findAll();
    }

    @Override
    @Transactional
    public void save(Book book) {
        bookDAO.save(book);
    }

    @Override
    @Transactional
    public void delete(Book book) {
        bookDAO.delete(book);
    }

    @Override
    @Transactional(readOnly = true)
    public Book findBook(Book book) {
        return bookDAO.findById(book.getBook_id()).orElse(null);
    }

}
