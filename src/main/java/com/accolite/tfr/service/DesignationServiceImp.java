package com.accolite.tfr.service;

import com.accolite.tfr.DTO.DesignationDTO;
import com.accolite.tfr.DTOmodel.DesignationModel;
import com.accolite.tfr.model.Designation;
import com.accolite.tfr.repository.DesignationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DesignationServiceImp implements DesignationService{

    @Autowired
    private DesignationRepository designationRepository;
    @Autowired(required = false)
    public DesignationDTO designationDTO;

    public Designation addDesignation(DesignationModel od) {
        Designation designation = this.designationDTO.modelToEntity(od);
        return this.designationRepository.save(designation);
    }

}
