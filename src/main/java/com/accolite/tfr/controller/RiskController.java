package com.accolite.tfr.controller;


import com.accolite.tfr.DTO.RiskDTO;
import com.accolite.tfr.entity.Risk;
import com.accolite.tfr.DTOmodel.RiskModel;
import com.accolite.tfr.repository.RiskRepository;
import com.accolite.tfr.service.RiskServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tfr")
public class RiskController {

    @Autowired
    private RiskRepository riskRepository;
    @Autowired
    public RiskServiceImp riskServiceImp;
    @Autowired(required = false)
    public RiskDTO riskDTO;

    @PostMapping("/addRisk")
    private ResponseEntity<RiskModel> addRisk(@RequestBody RiskModel riskModel) {
        Risk risk = this.riskServiceImp.addRisk(riskModel);
        RiskModel riskModel1=riskDTO.entityToModel(risk);
        return ResponseEntity.ok().body(riskModel1);
    }
}
