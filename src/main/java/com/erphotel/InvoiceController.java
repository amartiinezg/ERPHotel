package com.erphotel;

import com.erphotel.Booking.domain.Book;
import com.erphotel.Booking.service.BookService;
import com.erphotel.invoiceManagement.domain.InvoiceDomain;
import com.erphotel.invoiceManagement.domain.InvoiceLinesDomain;
import com.erphotel.invoiceManagement.enums.InvoiceTypesENUM;
import com.erphotel.invoiceManagement.service.InvoiceLinesService;
import com.erphotel.invoiceManagement.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private BookService bookService;

    @Autowired
    InvoiceLinesService invoiceLinesService;

    private static int invoice_id_temp;

    @GetMapping ("/invoice")
    public String InvoiceMainPage(Model model){
        List<InvoiceDomain> invoiceList = invoiceService.invoiceList();
        model.addAttribute("invoices", invoiceList);
        return "invoice";
    }

    @GetMapping ("/newInvoice")
    public String createNewInvoice(Model model){
        model.addAttribute("invoice", new InvoiceDomain());
        List<Book> books = bookService.listBooks();
        model.addAttribute("books_list", books);
        return "createNewInvoiceForm";
    }

    @PostMapping("/saveInvoice")
    public String saveNewInvoice(@ModelAttribute ("invoice") InvoiceDomain invoiceEntity, Model model){
        invoiceService.save(invoiceEntity);
        return "redirect:/invoice";
    }


    @GetMapping ("/deleteInvoice/{invoice_id}")
    private String deleteInvoice(@PathVariable int invoice_id, Model model){

        invoiceService.delete(invoice_id);

        return "redirect:/invoice";
    }

    //Invoice Lines

    @GetMapping ("/deleteInvoiceLine/{invoice_line_id}")
    private String deleteInvoiceLine(@PathVariable int invoice_line_id, Model model){
        invoiceLinesService.delete(invoice_line_id);
        return "redirect:/invoiceLines/"+invoice_id_temp;
    }

    @GetMapping ("/invoiceLines/{invoice_id}")
    private String invoiceLines(@PathVariable int invoice_id, Model model){
        Optional<InvoiceDomain> invoiceDomain = invoiceService.findByInvoiceID(invoice_id);
        List<InvoiceLinesDomain> invoiceLinesList = invoiceDomain.get().getInvoiceLinesDomainList();
        invoice_id_temp = invoice_id;
        model.addAttribute("invoiceList", invoiceLinesList);
        return "invoiceLine";
    }

    @GetMapping ("/editInvoice/{invoice_id}")
    public String editInvoice (@PathVariable int invoice_id, Model model){
        Optional<InvoiceDomain> invoiceDomain = invoiceService.findByInvoiceID(invoice_id);
        model.addAttribute("invoice", invoiceDomain);
        return "editInvoiceForm";
    }

    @GetMapping ("/editInvoiceLine/{invoice_line_id}")
    private String editInvoiceLines(@PathVariable int invoice_line_id, Model model){
        Optional<InvoiceLinesDomain> invoiceLinesDomain = invoiceLinesService.findById(invoice_line_id);
        model.addAttribute("invoice_id", invoice_id_temp);
        model.addAttribute("invoiceLine", invoiceLinesDomain);
        return "editInvoiceLineForm";
    }

    @GetMapping ("/newInvoiceLine")
    private String newInvoiceLine(Model model){
        InvoiceLinesDomain invoiceLine = new InvoiceLinesDomain();
        InvoiceTypesENUM[] services = InvoiceTypesENUM.values();

        model.addAttribute("invoiceLine", invoiceLine);
        model.addAttribute("services", services);
        model.addAttribute("invoice_id", invoice_id_temp);
        return "createNewInvoiceLineForm";
    }

    @PostMapping ("/saveInvoiceLine/{invoice_id}")
    private String saveInvoiceLines(@ModelAttribute ("invoiceLine") InvoiceLinesDomain invoiceLinesDomain, Model model, @PathVariable InvoiceDomain invoice_id){
        invoiceLinesDomain.setInvoice_id(invoice_id);
        invoiceLinesService.save(invoiceLinesDomain);
        return "redirect:/invoiceLines/" + invoice_id_temp;
    }




}
