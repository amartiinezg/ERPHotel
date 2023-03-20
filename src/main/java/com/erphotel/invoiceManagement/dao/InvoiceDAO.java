package com.erphotel.invoiceManagement.dao;

import com.erphotel.invoiceManagement.domain.InvoiceDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceDAO extends JpaRepository<InvoiceDomain, Integer> {
}
