package com.accolite.tfr.service;

import com.accolite.tfr.dto.DesignationDto;
import com.accolite.tfr.model.Designation;

public interface DesignationService {

    public Designation addDesignation(DesignationDto orgDto);
    public DesignationDto mapToDto(Designation org);
    public Designation mapToEntity(DesignationDto od);
}
