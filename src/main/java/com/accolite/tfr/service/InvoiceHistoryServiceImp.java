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
import java.util.Comparator;
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
        Optional<Project> project = this.projectRepository.findById(invoiceHistory.getProjectInvoiceHistory().getId());
        if(project.isPresent()){
            Project getProject = project.get();
            getProject.setInvoicing_status(invoiceHistory.getInvoice_status());
            getProject.setName(getProject.getName());
            getProject.setCurrent_pointer(getProject.getCurrent_pointer());
            getProject.setStart_date(getProject.getStart_date());
            getProject.setEnd_date(getProject.getEnd_date());
            getProject.setParent_id(getProject.getParent_id());
            getProject.setRag_status(getProject.getRag_status());
            getProject.setSow(getProject.getSow());
            getProject.setTotal_resource(getProject.getTotal_resource());
            getProject.setClient(getProject.getClient());
            getProject.setCreatedBy(getProject.getCreatedBy());
            getProject.setDepartment(getProject.getDepartment());
            getProject.setDivision(getProject.getDivision());
            getProject.setSuperDepartment(getProject.getSuperDepartment());
            getProject.setDepHead(getProject.getDepHead());
            getProject.setProjectLead(getProject.getProjectLead());
            getProject.setModifiedBy(getProject.getModifiedBy());
            getProject.setSpoc(getProject.getSpoc());
            this.projectRepository.save(getProject);
            return this.invoiceHistoryRepository.save(invoiceHistory);
        }
        else {
            throw new Exception("Project ID not found");
        }
    }

    public ResponseEntity<List<InvoiceHistory>> getInvoiceHistoryByProjectID(int p_id){
        Optional<Project> project = this.projectRepository.findById(p_id);
        if (project.isPresent()) {
            Project proj=project.get();
            List<InvoiceHistory> invoiceHistory = this.invoiceHistoryRepository.getInvoiceHistoryByPID(p_id);
            invoiceHistory.sort(Comparator.comparing(InvoiceHistory::getDate_of_add));
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

//    public ResponseEntity<InvoiceHistory> raiseInvoice(int p_id, String type) {
//        Optional<Project> project = this.projectRepository.findById(p_id);
//        if(project.isPresent()){
//            Project getProject = project.get();
//            getProject.setInvoicing_status(type);
//            return this.invoiceHistoryRepository.save(invoiceHistory);
//        }
//        else {
//            throw new Exception("Project ID not found");
//        }
//    }
}
