package com.accolite.tfr.controller;


import com.accolite.tfr.DTO.ResourceHistoryDTO;
import com.accolite.tfr.model.ResourceHistory;
import com.accolite.tfr.DTOmodel.ResourceHistoryModel;
import com.accolite.tfr.repository.ResourceHistoryRepository;
import com.accolite.tfr.service.ResourceHistoryServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200")
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

    @GetMapping("/getResourceHistoryByRID/{r_id}")
    private  ResponseEntity<List<ResourceHistoryModel>> getResourceHistoryByResource(@PathVariable int r_id){
        List<ResourceHistory> newList = this.resourceHistoryServiceImp.getResourceHistoryByResourceId(r_id);
        List<ResourceHistoryModel> resourceHistoryModels=this.resourceHistoryDTO.allEntitiesToModels(newList);
        return ResponseEntity.ok().body(resourceHistoryModels);
    }

    @GetMapping("/getResourceHistoryByPID/{p_id}")
    private  ResponseEntity<List<ResourceHistoryModel>> getResourceHistoryByProject(@PathVariable int p_id){
        List<ResourceHistory> newList = this.resourceHistoryServiceImp.getResourceHistoryByProjectId(p_id);
        List<ResourceHistoryModel> resourceHistoryModels=this.resourceHistoryDTO.allEntitiesToModels(newList);
        return ResponseEntity.ok().body(resourceHistoryModels);
    }
}
