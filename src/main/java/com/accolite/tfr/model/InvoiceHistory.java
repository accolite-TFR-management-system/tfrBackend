package com.accolite.tfr.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name="invoice_history")
public class InvoiceHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable = false)
    int id;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType. DETACH})
    @JoinColumn(name="project_id",referencedColumnName = "id")
    private Project ProjectInvoiceHistory;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType. DETACH})
    @JoinColumn(name="added_by",referencedColumnName = "id")
    private Resource InvoiceHistoryCreatedBy;

    @Column(name="invoice_status")
    String invoice_status;

    @Column(name="date_of_add")
    Date date_of_add;

}
