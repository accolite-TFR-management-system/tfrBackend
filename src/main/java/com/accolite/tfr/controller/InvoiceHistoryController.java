package com.accolite.tfr.controller;


import com.accolite.tfr.DTOmodel.ProjectModel;
import com.accolite.tfr.model.InvoiceHistory;
import com.accolite.tfr.model.Project;
import com.accolite.tfr.repository.InvoiceHistoryRepository;
import com.accolite.tfr.repository.ProjectRepository;
import com.accolite.tfr.service.InvoiceHistoryServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/tfr")
public class InvoiceHistoryController {

    @Autowired
    public InvoiceHistoryRepository invoiceHistoryRepository;

    @Autowired
    public ProjectRepository projectRepository;

    @Autowired
    public InvoiceHistoryServiceImp invoiceHistoryServiceImpl;

    @PostMapping("/addInvoiceHistory")
    private ResponseEntity<InvoiceHistory> addInvoiceHistory(@RequestBody InvoiceHistory ih) {
        InvoiceHistory invoiceHistory=this.invoiceHistoryServiceImpl.addInvoiceHistory(ih);
        return ResponseEntity.ok().body(invoiceHistory);
    }

    @GetMapping("/getInvoiceHistoryByPID/{p_id}")
    private  ResponseEntity<List<InvoiceHistory>> getInvoiceHistoryByPID(@PathVariable("p_id") int p_id) {
        ResponseEntity<List<InvoiceHistory>>  list = this.invoiceHistoryServiceImpl.getInvoiceHistoryByProjectID(p_id);
        return list;
    }

//    @PostMapping("/raiseInvoice/{p_id}/{status}")
//    private ResponseEntity<InvoiceHistory> raiseInvoice(@PathVariable("p_id") int p_id,@PathVariable("status") String type){
//        ResponseEntity<InvoiceHistory> invoice = this.invoiceHistoryServiceImpl.raiseInvoice(p_id,type);
//        return invoice;
//
//    }
}
