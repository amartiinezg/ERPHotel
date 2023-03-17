package com.erphotel.invoiceManagment.domain;

import com.erphotel.invoiceManagment.enums.InvoiceTypesENUM;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
@Entity
@Table(name = "invoice_lines")

public class InvoiceLinesDomain implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int invoice_line_id;
    @Enumerated (EnumType.STRING)
    private InvoiceTypesENUM invoice_line_type;
    private Date invoice_line_date;

    @ManyToOne
    private InvoiceDomain invoiceID;
}
