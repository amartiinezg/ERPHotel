package com.erphotel.invoiceManagement.service;

import com.erphotel.invoiceManagement.domain.InvoiceDomain;

import java.util.List;
import java.util.Optional;

public interface InvoiceService {
    public List<InvoiceDomain> invoiceList();

    public int save(InvoiceDomain invoice);

    public void delete(InvoiceDomain invoice);
    public Optional<InvoiceDomain> findByInvoiceID(int invoice_id);
}
