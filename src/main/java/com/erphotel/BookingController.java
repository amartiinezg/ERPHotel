package com.erphotel;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.erphotel.Booking.domain.Book;
import com.erphotel.Booking.domain.Guest;
import com.erphotel.Booking.service.BookService;
import com.erphotel.Booking.service.GuestService;
import com.erphotel.invoiceManagement.domain.InvoiceDomain;
import com.erphotel.invoiceManagement.enums.PayMethodsEnum;
import com.erphotel.invoiceManagement.service.InvoiceService;
import com.erphotel.personManagement.domain.PersonDomain;
import com.erphotel.personManagement.service.PersonService;
import com.erphotel.rooms.domain.Room;
import com.erphotel.rooms.services.RoomService;

@Controller
public class BookingController {

    @Autowired
    PersonService personService;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    InvoiceService invoiceService;

    @Autowired
    BookService bookService;

    @Autowired
    GuestService guestService;

    @Autowired
    RoomService roomService;

    @GetMapping("/hotel_booking")
    public String bookingWidget(Model model) {
        List<PersonDomain> personas = personService.listPersonas();
        model.addAttribute("personas", personas);
        return "hotel_booking";
    }

    @GetMapping("/books")
    public void booksWidget(Model model) {
        List<Book> bookList = bookService.listBooks();
        model.addAttribute("bookList", bookList);

    }

    @GetMapping("/book_confirm")
    public void bookingWidget() {
    }

    @PostMapping("/processFormBooking")
    public String create(@ModelAttribute("persona") PersonDomain persona, @ModelAttribute("reserva") Book book,
            @ModelAttribute("huesped") Guest guest, @ModelAttribute("factura") InvoiceDomain invoice,
            @RequestParam("room_type") String roomType, @RequestParam("nonselected") String existentGuest) {
        List<Room> rooms = roomService.roomList();
        while (book.getRoom() == null) {
            for (Room room : rooms) {
                if (room.getRoom_type().equals(roomType)) {
                    if (room.isStatus() != false) {
                        book.setRoom(room);
                        room.setStatus(false);
                        roomService.save(room);
                        break;
                    }
                }
            }
        }

        if (!existentGuest.equals("blank")) {
            bookService.save(book);
            guest.setPerson_id(Integer.parseInt(existentGuest));
            guestService.save(guest);
            invoice.setInvoice_id(book.getBook_id().intValue());
            invoice.setInvoice_date(Date.valueOf(LocalDate.now()));
            invoice.setInvoice_status("Pendiente");
            invoice.setInvoice_quantity(0);
            invoice.setPay_method(PayMethodsEnum.Tarjeta);
            invoiceService.save(invoice);
            return "book_confirm";
        } else {
            personService.salvar(persona);
            bookService.save(book);
            guest.setPerson_id(persona.getPerson_id().intValue());
            guestService.save(guest);
            invoice.setInvoice_id(book.getBook_id().intValue());
            invoice.setInvoice_date(Date.valueOf(LocalDate.now()));
            invoice.setInvoice_status("Pendiente");
            invoice.setInvoice_quantity(0);
            invoice.setPay_method(PayMethodsEnum.Tarjeta);
            invoiceService.save(invoice);

            return "book_confirm";
        }
    }
}
