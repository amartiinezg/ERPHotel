package com.erphotel.invoiceManagement.service;

import com.erphotel.invoiceManagement.dao.InvoiceLinesDAO;
import com.erphotel.invoiceManagement.domain.InvoiceLinesDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceLinesImpl implements InvoiceLinesService{
    @Autowired
    InvoiceLinesDAO invoiceLinesDAO;

    @Override
    public List<InvoiceLinesDomain> invoiceList() {
        return (List<InvoiceLinesDomain>) invoiceLinesDAO.findAll();
    }

    @Override
    public void save(InvoiceLinesDomain invoiceLines) {
    invoiceLinesDAO.save(invoiceLines);
    }

    @Override
    public void delete(int id) {
        invoiceLinesDAO.deleteById(id);
    }

    @Override
    public Optional<InvoiceLinesDomain> findById(int invoice_line_id) {

        return invoiceLinesDAO.findById(invoice_line_id);
    }


}





