package com.erphotel.invoiceManagement.service;

import com.erphotel.invoiceManagement.dao.InvoiceDAO;
import com.erphotel.invoiceManagement.domain.InvoiceDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceImpl implements InvoiceService{
    @Autowired
    InvoiceDAO invoiceDAO;

    @Override
    public List<InvoiceDomain> invoiceList() {
        return invoiceDAO.findAll();
    }

    @Override
    public void save(InvoiceDomain invoice) {
        invoiceDAO.save(invoice);
    }

    @Override
    public void delete(int id) {
        invoiceDAO.deleteById(id);
    }


    @Override
    public Optional<InvoiceDomain> findByInvoiceID(int invoice_id) {
        return invoiceDAO.findById(invoice_id);
    }


}


