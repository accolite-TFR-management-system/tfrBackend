package com.accolite.tfr.controller;


import com.accolite.tfr.DTO.MilestoneDTO;
import com.accolite.tfr.model.Milestone;
import com.accolite.tfr.DTOmodel.MilestoneModel;
import com.accolite.tfr.repository.MilestoneRepository;
import com.accolite.tfr.service.MilestoneServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/tfr")
public class MilestoneController {

    @Autowired
    private MilestoneRepository milestoneRepository;
    @Autowired
    public MilestoneServiceImp milestoneServiceImp;
    @Autowired
    public MilestoneDTO milestoneDTO;

    @PostMapping("/addMilestone")
    private ResponseEntity<MilestoneModel> addDesignation(@RequestBody MilestoneModel milestoneModel) {
        Milestone milestone = this.milestoneServiceImp.addMilestone(milestoneModel);
        MilestoneModel milestoneModel1=milestoneDTO.entityToModel(milestone);
        return ResponseEntity.ok().body(milestoneModel1);
    }

    @GetMapping("/getMilestone/{p_id}")
    private ResponseEntity<List<MilestoneModel>> getMilestone(@PathVariable int p_id){
        List<Milestone> newMilestone = this.milestoneServiceImp.getMilestone(p_id);
        List<MilestoneModel> milestoneModels=this.milestoneDTO.allEntitiesToModels(newMilestone);
        return  ResponseEntity.ok().body(milestoneModels);
    }

    @PatchMapping("/updateMilestone/{m_id}")
    private ResponseEntity<?> updateMilestone(@PathVariable("m_id") int milestoneId,@RequestBody Map<Object,Object> fields){
        return milestoneServiceImp.updateMilestone(milestoneId,fields);
    }


}
