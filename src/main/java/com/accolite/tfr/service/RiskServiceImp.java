package com.accolite.tfr.service;

import com.accolite.tfr.dto.RiskDto;
import com.accolite.tfr.model.Risk;
import com.accolite.tfr.repository.RiskRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RiskServiceImp implements RiskService{

    @Autowired
    private RiskRepository riskRepository;
    @Autowired
    public ModelMapper modelMapper;

    public Risk addRisk(RiskDto od) {
        Risk risk = this.mapToEntity(od);
        return this.riskRepository.save(risk);
    }

    public RiskDto mapToDto(Risk org) {
        RiskDto od = modelMapper.map(org,RiskDto.class);
        return od;
    }

    public Risk mapToEntity(RiskDto od) {
        Risk org = modelMapper.map(od, Risk.class);
        return org;
    }
}
