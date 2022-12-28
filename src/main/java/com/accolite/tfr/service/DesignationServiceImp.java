package com.accolite.tfr.service;

import com.accolite.tfr.dto.DesignationDto;
import com.accolite.tfr.model.Designation;
import com.accolite.tfr.repository.DesignationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DesignationServiceImp implements DesignationService{

    @Autowired
    private DesignationRepository designationRepository;
    @Autowired
    public ModelMapper modelMapper;

    public Designation addDesignation(DesignationDto od) {
        Designation designation = this.mapToEntity(od);
        return this.designationRepository.save(designation);
    }

    public DesignationDto mapToDto(Designation org) {
        DesignationDto od = modelMapper.map(org,DesignationDto.class);
        return od;
    }

    public Designation mapToEntity(DesignationDto od) {
        Designation org = modelMapper.map(od,Designation.class);
        return org;
    }
}
