package com.erphotel;

import com.erphotel.invoiceManagment.domain.InvoiceDomain;
import com.erphotel.invoiceManagment.domain.InvoiceLinesDomain;
import com.erphotel.invoiceManagment.service.InvoiceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class InvoiceController {
    private InvoiceService invoiceService;
    @GetMapping ("/invoice")
    public String InvoiceMainPage(Model model){
        Iterable<InvoiceLinesDomain> invoiceList = invoiceService.invoiceList();
        model.addAttribute("invoices", invoiceList);
        return "invoice";
    }


}
