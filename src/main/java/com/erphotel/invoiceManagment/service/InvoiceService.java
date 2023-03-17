package com.erphotel.invoiceManagment.service;

import com.erphotel.invoiceManagment.domain.InvoiceDomain;

import java.util.List;

public interface InvoiceService {
    public List<InvoiceDomain> invoiceList();

    public void save(InvoiceDomain invoice);

    public void delete(InvoiceDomain invoice);

    public InvoiceDomain findInvoice (InvoiceDomain invoice);
}
