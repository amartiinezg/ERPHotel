package com.erphotel.invoiceManagement.service;

import com.erphotel.invoiceManagement.domain.InvoiceLinesDomain;

import java.util.List;

public interface InvoiceLinesService {
    public List<InvoiceLinesDomain> invoiceList();

    public void save(InvoiceLinesDomain invoice);

    public void delete(int invoice_id);
    public List<InvoiceLinesDomain> findAllById(int invoice_id);


}
