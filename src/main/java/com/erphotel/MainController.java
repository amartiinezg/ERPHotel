package com.erphotel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.erphotel.Booking.domain.Book;
import com.erphotel.Booking.service.BookService;
import com.erphotel.personManagement.domain.PersonDomain;
import com.erphotel.personManagement.service.PersonService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;

@Controller
public class MainController {

    @Autowired
    private BookService bookService;
    private PersonService personService;

    @GetMapping("person")
    public String listPerson(Model model, @AuthenticationPrincipal User username) {
        List<PersonDomain> personas = personService.listPersonas();
        model.addAttribute("personas", personas);
        return "person";
    }

    /*@AuthenticationPrincipal retorna l'usuari autenticat actualment com un objecte User de Spring security*/
    @GetMapping("/") //Pàgina inicial dels gossos    
    public String inici(Model model, @AuthenticationPrincipal User username) {
        List<PersonDomain> personas = personService.listPersonas();
        model.addAttribute("personas", personas);
        return "person";
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
}
