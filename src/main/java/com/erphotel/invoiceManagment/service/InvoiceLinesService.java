package com.erphotel.invoiceManagment.service;

import com.erphotel.invoiceManagment.domain.InvoiceLinesDomain;
import com.erphotel.personManagement.domain.PersonDomain;
import org.springframework.stereotype.Service;

import java.util.List;

public interface InvoiceLinesService {
    public List<InvoiceLinesDomain> invoiceLines();

    public void save(InvoiceLinesDomain invoiceLine);

    public void delete (InvoiceLinesDomain invoiceLine);

    public InvoiceLinesDomain findInvoiceLine (InvoiceLinesDomain invoiceLine);
}
