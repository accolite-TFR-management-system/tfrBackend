package com.accolite.tfr.service;

import com.accolite.tfr.model.InvoiceHistory;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface InvoiceHistoryService {
    public InvoiceHistory addInvoiceHistory(InvoiceHistory invoiceHistory);

    public ResponseEntity<List<InvoiceHistory>> getInvoiceHistoryByProjectID(int p_id);
}
