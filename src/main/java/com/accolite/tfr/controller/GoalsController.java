package com.accolite.tfr.controller;


import com.accolite.tfr.DTO.GoalsDTO;
import com.accolite.tfr.entity.Goals;
import com.accolite.tfr.DTOmodel.GoalsModel;
import com.accolite.tfr.repository.GoalRepository;
import com.accolite.tfr.service.GoalsServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tfr")
public class GoalsController {

    @Autowired
    private GoalRepository goalRepository;
    @Autowired
    public GoalsServiceImp goalsServiceImp;
    @Autowired(required = false)
    public GoalsDTO goalsDTO;

    @PostMapping("/addGoals")
    private ResponseEntity<GoalsModel> addGoals(@RequestBody GoalsModel goalsModel) {
        Goals goals = this.goalsServiceImp.addGoals(goalsModel);
        GoalsModel goalsModel1=goalsDTO.entityToModel(goals);
        return ResponseEntity.ok().body(goalsModel1);
    }

}
