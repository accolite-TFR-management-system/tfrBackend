package com.accolite.tfr.service;


import com.accolite.tfr.DTOmodel.RiskModel;
import com.accolite.tfr.entity.Risk;

public interface RiskService {

    public Risk addRisk(RiskModel orgDto);
}
