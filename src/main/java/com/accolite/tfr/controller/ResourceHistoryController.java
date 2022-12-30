package com.accolite.tfr.controller;


import com.accolite.tfr.DTO.ResourceHistoryDTO;
import com.accolite.tfr.entity.ResourceHistory;
import com.accolite.tfr.DTOmodel.ResourceHistoryModel;
import com.accolite.tfr.repository.ResourceHistoryRepository;
import com.accolite.tfr.service.ResourceHistoryServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tfr")
public class ResourceHistoryController {

    @Autowired
    private ResourceHistoryRepository resourceHistoryRepository;
    @Autowired
    public ResourceHistoryServiceImp resourceHistoryServiceImp;
    @Autowired(required = false)
    public ResourceHistoryDTO resourceHistoryDTO;

    @PostMapping("/addResourceHistory")
    private ResponseEntity<ResourceHistoryModel> addResourceHistory(@RequestBody ResourceHistoryModel resourceHistoryModel) {
        ResourceHistory resourceHistory = this.resourceHistoryServiceImp.addResourceHistory(resourceHistoryModel);
        ResourceHistoryModel resourceHistoryModel1=resourceHistoryDTO.entityToModel(resourceHistory);
        return ResponseEntity.ok().body(resourceHistoryModel1);
    }
}
