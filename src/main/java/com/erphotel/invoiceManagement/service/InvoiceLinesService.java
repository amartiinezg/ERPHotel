package com.erphotel.invoiceManagement.service;

import com.erphotel.invoiceManagement.domain.InvoiceLinesDomain;

import java.util.List;

public interface InvoiceLinesService {
    public List<InvoiceLinesDomain> invoiceLines();

    public void save(InvoiceLinesDomain invoiceLine);

    public void delete (InvoiceLinesDomain invoiceLine);

    public InvoiceLinesDomain findInvoiceLine (InvoiceLinesDomain invoiceLine);
}
