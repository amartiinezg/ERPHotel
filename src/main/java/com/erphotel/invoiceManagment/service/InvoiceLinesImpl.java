package com.erphotel.invoiceManagment.service;

import com.erphotel.invoiceManagment.dao.InvoiceLinesDAO;
import com.erphotel.invoiceManagment.domain.InvoiceDomain;
import com.erphotel.invoiceManagment.domain.InvoiceLinesDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceLinesImpl implements InvoiceLinesService{
    @Autowired
    InvoiceLinesDAO invoiceLinesDAO;
    @Override
    public List<InvoiceLinesDomain> invoiceLines() {
        return (List<InvoiceLinesDomain>) invoiceLinesDAO.findAll();
    }

    @Override
    public void save(InvoiceLinesDomain invoiceLine) {

    }

    @Override
    public void delete(InvoiceLinesDomain invoiceLine) {

    }

    @Override
    public InvoiceLinesDomain findInvoiceLine(InvoiceLinesDomain invoiceLine) {
        return null;
    }
}
