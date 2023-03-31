package com.erphotel.invoiceManagement.service;

import com.erphotel.invoiceManagement.domain.InvoiceLinesDomain;

import java.util.List;
import java.util.Optional;

public interface InvoiceLinesService {
    public List<InvoiceLinesDomain> invoiceList();

    public void save(InvoiceLinesDomain invoice);

    public void delete(int invoice_id);

    public Optional<InvoiceLinesDomain> findById(int invoice_line_id);


}
