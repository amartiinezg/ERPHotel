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
        return (List<InvoiceDomain>) invoiceDAO.findAll();
    }

    @Override
    public int save(InvoiceDomain invoice) {
    int res = 0;

    InvoiceDomain invoiceDomain = invoiceDAO.save(invoice);

    if(invoiceDomain != null){
        res = 1;
    }

    return res;
    }

    @Override
    public void delete(InvoiceDomain invoice) {

    }

    @Override
    public Optional<InvoiceDomain> findByInvoiceID(int invoice_id) {
        return invoiceDAO.findById((long) invoice_id);
    }


}


