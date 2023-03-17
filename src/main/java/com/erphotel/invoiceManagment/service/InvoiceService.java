package com.erphotel.invoiceManagment.service;

import com.erphotel.invoiceManagment.domain.InvoiceDomain;
import com.erphotel.invoiceManagment.domain.InvoiceLinesDomain;

public interface InvoiceService {
    public Iterable<InvoiceLinesDomain> invoiceList();

    public void save(InvoiceDomain invoice);

    public void delete(InvoiceDomain invoice);

    public InvoiceDomain findInvoice (InvoiceDomain invoice);
}
