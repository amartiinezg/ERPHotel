package com.erphotel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.erphotel.Booking.domain.Book;
import com.erphotel.Booking.service.BookService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
    private final String USERNAME = "admin";
    private final String PASSWORD = "wipe";

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String loginScreen() {
        return "indice";
    }

    @GetMapping("/rooms")
    public String roomWidget() {
        return "rooms";
    }

    @GetMapping("/hotel_booking")
    public String bookingWidget(Model model) {
        List<Book> books = bookService.listBooks();
        for (Book book : books) {
            System.out.println(book.toString());
        }
        model.addAttribute("books", books);
        return "hotel_booking";
    }

    @GetMapping("/home")
    public String home(HttpSession session) {
        if (session.getAttribute("loggedIn") != null && (Boolean) session.getAttribute("loggedIn")) {
            return "home";
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session) {
        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            session.setAttribute("loggedIn", true);
            return "redirect:/home";
        } else {
            return "redirect:/";
        }
    }
}
