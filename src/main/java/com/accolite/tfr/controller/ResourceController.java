package com.accolite.tfr.controller;


import com.accolite.tfr.DTO.ResourceDTO;
import com.accolite.tfr.entity.Resource;
import com.accolite.tfr.DTOmodel.ResourceModel;
import com.accolite.tfr.repository.ResourceRepository;
import com.accolite.tfr.service.ResourceServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tfr")
public class ResourceController {

    @Autowired
    private ResourceRepository resourceRepository;
    @Autowired
    public ResourceServiceImp resourceServiceImp;
    @Autowired(required = false)
    public ResourceDTO resourceDTO;

    @PostMapping("/addResource")
    private ResponseEntity<ResourceModel> addResource(@RequestBody ResourceModel resourceModel) {
        Resource resource = this.resourceServiceImp.addResource(resourceModel);
        ResourceModel resourceModel1 = this.resourceDTO.entityToModel(resource);
        return ResponseEntity.ok().body(resourceModel1);
    }
}
