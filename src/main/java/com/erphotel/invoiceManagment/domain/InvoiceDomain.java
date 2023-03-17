package com.erphotel.invoiceManagment.domain;

import com.erphotel.invoiceManagment.enums.PayMethodsEnum;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Data
@Entity
@Table (name = "invoices")

public class InvoiceDomain implements Serializable {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int invoice_id;
    private Date invoice_date;
    private int invoice_status;
    private float invoice_quantity;
    @Enumerated (EnumType.STRING)
    private PayMethodsEnum pay_method;
    @OneToMany
    private List<InvoiceLinesDomain> invoiceLines;

}
