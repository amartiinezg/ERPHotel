package com.erphotel.invoiceManagement.service;

import com.erphotel.invoiceManagement.dao.InvoiceLinesDAO;
import com.erphotel.invoiceManagement.domain.InvoiceLinesDomain;
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
