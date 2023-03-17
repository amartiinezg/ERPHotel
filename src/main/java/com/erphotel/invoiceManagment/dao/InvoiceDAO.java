package com.erphotel.invoiceManagment.dao;

import com.erphotel.invoiceManagment.domain.InvoiceDomain;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceDAO extends CrudRepository<InvoiceDomain, Long> {
}
