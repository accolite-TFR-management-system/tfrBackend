package com.accolite.tfr.service;


import com.accolite.tfr.dto.RiskDto;
import com.accolite.tfr.model.Risk;

public interface RiskService {

    public Risk addRisk(RiskDto orgDto);
    public RiskDto mapToDto(Risk org);
    public Risk mapToEntity(RiskDto od);
}
