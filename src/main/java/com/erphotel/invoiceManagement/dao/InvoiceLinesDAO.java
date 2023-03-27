package com.erphotel.invoiceManagement.dao;

import com.erphotel.invoiceManagement.domain.InvoiceLinesDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceLinesDAO extends CrudRepository<InvoiceLinesDomain, Integer> {
}
