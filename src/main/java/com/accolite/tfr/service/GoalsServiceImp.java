package com.accolite.tfr.service;

import com.accolite.tfr.DTO.GoalsDTO;
import com.accolite.tfr.DTOmodel.GoalsModel;
import com.accolite.tfr.exception.Exception;
import com.accolite.tfr.model.Goals;
import com.accolite.tfr.model.Milestone;
import com.accolite.tfr.repository.GoalRepository;
import com.accolite.tfr.repository.MilestoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class GoalsServiceImp implements GoalsService{

    @Autowired
    private GoalRepository goalRepository;

    @Autowired
    private MilestoneRepository milestoneRepository;

    @Autowired(required = false)
    public GoalsDTO goalsDTO;

    public Goals addGoals(GoalsModel od) {
        Goals goals = goalsDTO.modelToEntity(od);
        return this.goalRepository.save(goals);
    }

    public Goals getGoal(int g_id) {
        Optional<Goals> goal = this.goalRepository.findById(g_id);
        if(goal.isPresent()) {
            return goal.get();
        }
        else {
            throw new Exception("goal not found");
        }
    }

    public List<Goals> getGoals(int m_id) {
        Optional<Milestone> newMilestone =this.milestoneRepository.findById(m_id);
        if(newMilestone.isPresent()) {
            Optional<List<Goals>> newList = Optional.ofNullable(this.goalRepository.findResourceByMilestoneId(m_id));
            if (newList.isPresent()) {
                List<Goals> list = newList.get();
                list.sort(Comparator.comparing(Goals::getDate_of_add));
                return newList.get();
            } else {
                throw new Exception("goals not found");
            }
        }
        else {
            throw new Exception("Milestone not found");
        }
    }

    public ResponseEntity<?> updateGoals(int goalId, Map<Object, Object> fields) {
        Optional<Goals> getGoal = this.goalRepository.findById(goalId);
        if(getGoal.isPresent()){
            fields.forEach((key,value)->{
                Field field = ReflectionUtils.findField(Goals.class,(String) key);
                field.setAccessible(true);
                ReflectionUtils.setField(field,getGoal.get(),value);
            });
            Goals updatedGoal = this.goalRepository.save(getGoal.get());
            GoalsModel goalsModel=this.goalsDTO.entityToModel(updatedGoal);
            return new ResponseEntity<>(updatedGoal, HttpStatus.OK);
        }
        else {
            throw new Exception("Goal not found");
        }
    }

}
