package com.accolite.tfr.DTOmodel;

import com.accolite.tfr.model.Project;
import com.accolite.tfr.model.Resource;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
public class InvoiceHistoryModel {

    int id;
    private Project ProjectInvoiceHistory;
    private Resource InvoiceHistoryCreatedBy;
    String invoice_status;
    Date date_of_add;

}
