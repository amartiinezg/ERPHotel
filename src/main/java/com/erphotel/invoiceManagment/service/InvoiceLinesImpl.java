package com.erphotel.invoiceManagment.service;

import com.erphotel.invoiceManagment.dao.InvoiceDAO;
import com.erphotel.invoiceManagment.domain.InvoiceDomain;
import com.erphotel.invoiceManagment.domain.InvoiceLinesDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceLinesImpl implements InvoiceService{
    @Autowired
    InvoiceDAO invoiceDAO;
    @Override
    public Iterable<InvoiceLinesDomain> invoiceList() {
        return null;
    }

    @Override
    public void save(InvoiceDomain invoice) {

    }

    @Override
    public void delete(InvoiceDomain invoice) {

    }

    @Override
    public InvoiceDomain findInvoice(InvoiceDomain invoice) {
        return null;
    }
}
