package com.accolite.tfr.repository;

import com.accolite.tfr.model.InvoiceHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InvoiceHistoryRepository extends JpaRepository<InvoiceHistory,Integer> {

    @Query(value="select * from invoice_history where project_id=?1",nativeQuery = true)
    List<InvoiceHistory> getInvoiceHistoryByPID(int p_id);
}
