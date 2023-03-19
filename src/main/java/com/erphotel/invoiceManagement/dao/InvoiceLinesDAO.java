package com.erphotel.invoiceManagement.dao;

import com.erphotel.invoiceManagement.domain.InvoiceLinesDomain;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceLinesDAO extends CrudRepository<InvoiceLinesDomain, Long> {
}
