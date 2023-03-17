package com.erphotel.invoiceManagment.service;

import com.erphotel.invoiceManagment.dao.InvoiceDAO;
import com.erphotel.invoiceManagment.domain.InvoiceDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceImpl implements InvoiceService{
    @Autowired
InvoiceDAO invoiceDAO;
    @Override
    public List<InvoiceDomain> invoiceList() {
        return (List<InvoiceDomain>) invoiceDAO.findAll();
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
