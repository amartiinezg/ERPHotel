package com.erphotel.invoiceManagment.dao;

import com.erphotel.invoiceManagment.domain.InvoiceLinesDomain;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceLinesDAO extends CrudRepository<InvoiceLinesDomain, Long> {
}
