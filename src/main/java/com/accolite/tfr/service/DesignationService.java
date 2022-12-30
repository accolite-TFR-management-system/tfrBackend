package com.accolite.tfr.service;

import com.accolite.tfr.DTOmodel.DesignationModel;
import com.accolite.tfr.entity.Designation;

public interface DesignationService {

    public Designation addDesignation(DesignationModel orgDto);
}
