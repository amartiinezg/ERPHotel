package com.erphotel;

import com.erphotel.invoiceManagement.domain.InvoiceDomain;
import com.erphotel.invoiceManagement.service.InvoiceService;
import jakarta.validation.Valid;
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
    @GetMapping ("/invoice")
    public String InvoiceMainPage(Model model){
        List<InvoiceDomain> invoiceList = invoiceService.invoiceList();
        model.addAttribute("invoices", invoiceList);
        return "invoice";
    }

    @GetMapping ("/newInvoice")
    public String createNewInvoice(Model model){
        model.addAttribute("invoice", new InvoiceDomain());
        return "createNewInvoiceForm";
    }

    @PostMapping("/saveInvoice")
    public String saveNewInvoice(@ModelAttribute ("invoice") InvoiceDomain invoiceEntity, Model model){
        invoiceService.save(invoiceEntity);
    return "redirect:/invoice";
    }

    @GetMapping ("/editInvoice/{invoice_id}")
    public String editInvoice (@PathVariable int invoice_id, Model model){
        Optional<InvoiceDomain> invoiceDomain = invoiceService.findByInvoiceID(invoice_id);
        model.addAttribute("invoice", invoiceDomain);
        return "createNewInvoiceForm";
    }


}
