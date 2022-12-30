package com.accolite.tfr.service;

import com.accolite.tfr.DTO.RiskDTO;
import com.accolite.tfr.DTOmodel.RiskModel;
import com.accolite.tfr.entity.Risk;
import com.accolite.tfr.repository.RiskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RiskServiceImp implements RiskService{

    @Autowired
    private RiskRepository riskRepository;
    @Autowired(required = false)
    public RiskDTO riskDTO;

    public Risk addRisk(RiskModel od) {
        Risk risk = this.riskDTO.modelToEntity(od);
        return this.riskRepository.save(risk);
    }


}
