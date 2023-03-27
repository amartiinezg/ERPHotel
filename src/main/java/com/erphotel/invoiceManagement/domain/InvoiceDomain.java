package com.erphotel.invoiceManagement.domain;

import com.erphotel.invoiceManagement.enums.PayMethodsEnum;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Data
@Entity
@Table (name = "invoices")

public class InvoiceDomain implements Serializable {
    @Id
    private int invoice_id;
    private Date invoice_date;
    private int invoice_status;
    private float invoice_quantity;
    @Enumerated (EnumType.STRING)
    private PayMethodsEnum pay_method;

    @OneToMany (mappedBy = "invoice_id")
    List<InvoiceLinesDomain> invoiceLinesDomainList;

}
