package com.accolite.tfr.service;

import java.util.List;

import com.accolite.tfr.DTOmodel.DesignationModel;
import com.accolite.tfr.model.Designation;
import com.accolite.tfr.model.Organisation;

public interface DesignationService {

    public Designation addDesignation(DesignationModel orgDto);
    public List<Designation> getalldesignation();
}
