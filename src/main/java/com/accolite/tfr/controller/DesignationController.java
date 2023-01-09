package com.accolite.tfr.controller;

import com.accolite.tfr.DTO.DesignationDTO;
import com.accolite.tfr.model.Designation;
import com.accolite.tfr.model.Organisation;
import com.accolite.tfr.DTOmodel.DesignationModel;
import com.accolite.tfr.DTOmodel.OrganisationModel;
import com.accolite.tfr.repository.DesignationRepository;
import com.accolite.tfr.service.DesignationServiceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins="http://localhost:4200")
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
    
    @GetMapping("/getdesignation")
    private ResponseEntity<List<DesignationModel>> getalldesignation(){
        List<Designation> designations = this.designationServiceImp.getalldesignation();
        List<DesignationModel> designationsmodel=designationDTO.allEntitiesToModels(designations);
        return ResponseEntity.ok().body(designationsmodel);
    }
}
