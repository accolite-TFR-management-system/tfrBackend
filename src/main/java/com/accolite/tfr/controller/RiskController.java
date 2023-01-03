package com.accolite.tfr.controller;


import com.accolite.tfr.DTO.RiskDTO;
import com.accolite.tfr.model.Risk;
import com.accolite.tfr.DTOmodel.RiskModel;
import com.accolite.tfr.repository.RiskRepository;
import com.accolite.tfr.service.RiskServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tfr")
@CrossOrigin(origins="http://localhost:4200")
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

    @GetMapping("/getRisk/{p_id}")
    private ResponseEntity<List<RiskModel>> getRisk(@PathVariable int p_id) {
        List<Risk> newRisk = this.riskServiceImp.getRisk(p_id);
        List<RiskModel> riskModels=this.riskDTO.allEntitiesToModels(newRisk);
        return ResponseEntity.ok().body(riskModels);
    }

    @PatchMapping("/updateRisk/{r_id}")
    private ResponseEntity<?> updateRisk(@PathVariable("r_id") int riskId,@RequestBody Map<Object,Object> fields){
        return riskServiceImp.updateRisk(riskId,fields);
    }
}
