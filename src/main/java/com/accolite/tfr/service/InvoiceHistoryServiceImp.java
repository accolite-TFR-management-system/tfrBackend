package com.accolite.tfr.service;


import com.accolite.tfr.DTOmodel.ProjectModel;
import com.accolite.tfr.exception.Exception;
import com.accolite.tfr.model.InvoiceHistory;
import com.accolite.tfr.model.Project;
import com.accolite.tfr.repository.InvoiceHistoryRepository;
import com.accolite.tfr.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class InvoiceHistoryServiceImp {

    @Autowired
    private InvoiceHistoryRepository invoiceHistoryRepository;

    @Autowired
    private ProjectRepository projectRepository;

    public InvoiceHistory addInvoiceHistory(InvoiceHistory invoiceHistory) {
        return this.invoiceHistoryRepository.save(invoiceHistory);
    }

    public ResponseEntity<List<InvoiceHistory>> getInvoiceHistoryByProjectID(int p_id){
        Optional<Project> project = this.projectRepository.findById(p_id);
        if (project.isPresent()) {
            Project proj=project.get();
            List<InvoiceHistory> invoiceHistory = this.invoiceHistoryRepository.getInvoiceHistoryByPID(p_id);
            if(invoiceHistory.size()!=0) {
                return new ResponseEntity<List<InvoiceHistory>>(invoiceHistory,HttpStatus.OK);
            }
            else {
                return null;
            }
        }
        else {
            throw new Exception("Project ID not found");
        }
    }
}
