package com.accolite.tfr.controller;


import com.accolite.tfr.DTO.GoalsDTO;
import com.accolite.tfr.model.Goals;
import com.accolite.tfr.DTOmodel.GoalsModel;
import com.accolite.tfr.repository.GoalRepository;
import com.accolite.tfr.service.GoalsServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins="http://localhost:4200")
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

    @GetMapping("/getGoal/{g_id}")
    private ResponseEntity<GoalsModel> getGoal(@PathVariable int g_id){
        Goals newGoal = this.goalsServiceImp.getGoal(g_id);
        GoalsModel goalsModel=this.goalsDTO.entityToModel(newGoal);
        return  ResponseEntity.ok().body(goalsModel);
    }

    @GetMapping("/Goals/{m_id}")
    private ResponseEntity<List<GoalsModel>> getGoals(@PathVariable int m_id){
        List<Goals> newGoals= this.goalsServiceImp.getGoals(m_id);
        List<GoalsModel> goalsModel=this.goalsDTO.allEntitiesToModels(newGoals);
        return  ResponseEntity.ok().body(goalsModel);
    }
    @GetMapping("/GoalsByPid/{p_id}")
    private ResponseEntity<List<GoalsModel>> getGoalsByPid(@PathVariable int p_id){
        List<Goals> newGoals= this.goalsServiceImp.getGoalsByPid(p_id);
        List<GoalsModel> goalsModel=this.goalsDTO.allEntitiesToModels(newGoals);
        return  ResponseEntity.ok().body(goalsModel);
    }
//        @GetMapping("/GoalsByPid/{p_id}")
//    private ResponseEntity<List<GoalsModel>> getGoalsByPid(@PathVariable int p_id){
//        List<Goals> newGoals= this.goalsServiceImp.getGoalsByPid(p_id);
//        List<GoalsModel> goalsModel=this.goalsDTO.allEntitiesToModels(newGoals);
//        return  ResponseEntity.ok().body(goalsModel);
//    }

    @PatchMapping("/updateGoals/{g_id}")
    private ResponseEntity<?> updateGoal(@PathVariable("g_id") int goalId,@RequestBody Map<Object,Object> fields){
        return goalsServiceImp.updateGoals(goalId,fields);
    }

}
