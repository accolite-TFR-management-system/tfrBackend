package com.accolite.tfr.service;

import com.accolite.tfr.dto.GoalsDto;
import com.accolite.tfr.model.Goals;
import com.accolite.tfr.repository.GoalRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoalsServiceImp implements GoalsService{

    @Autowired
    private GoalRepository goalRepository;
    @Autowired
    public ModelMapper modelMapper;

    public Goals addGoals(GoalsDto od) {
        Goals goals = this.mapToEntity(od);
        return this.goalRepository.save(goals);
    }

    public GoalsDto mapToDto(Goals org) {
        GoalsDto od = modelMapper.map(org,GoalsDto.class);
        return od;
    }

    public Goals mapToEntity(GoalsDto od) {
        Goals org = modelMapper.map(od, Goals.class);
        return org;
    }

}
