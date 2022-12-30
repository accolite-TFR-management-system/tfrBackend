package com.accolite.tfr.service;

import com.accolite.tfr.DTO.GoalsDTO;
import com.accolite.tfr.DTOmodel.GoalsModel;
import com.accolite.tfr.entity.Goals;
import com.accolite.tfr.repository.GoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoalsServiceImp implements GoalsService{

    @Autowired
    private GoalRepository goalRepository;
    @Autowired(required = false)
    public GoalsDTO goalsDTO;

    public Goals addGoals(GoalsModel od) {
        Goals goals = goalsDTO.modelToEntity(od);
        return this.goalRepository.save(goals);
    }


}
