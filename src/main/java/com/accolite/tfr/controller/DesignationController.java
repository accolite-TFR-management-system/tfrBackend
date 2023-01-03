package com.accolite.tfr.controller;

import com.accolite.tfr.DTO.DesignationDTO;
import com.accolite.tfr.model.Designation;
import com.accolite.tfr.DTOmodel.DesignationModel;
import com.accolite.tfr.repository.DesignationRepository;
import com.accolite.tfr.service.DesignationServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tfr")
public class DesignationController {

    @Autowired
    private DesignationRepository designationRepository;
    @Autowired
    public DesignationServiceImp    designationServiceImp;
    @Autowired(required = false)
    public DesignationDTO designationDTO;

    @PostMapping("/addDesignation")
    private ResponseEntity<DesignationModel> addDesignation(@RequestBody DesignationModel designationModel) {
        Designation designation = this.designationServiceImp.addDesignation(designationModel);
        DesignationModel designationModel1=designationDTO.entityToModel(designation);
        return ResponseEntity.ok().body(designationModel1);
    }
}
