package com.accolite.tfr.DTO;

import com.accolite.tfr.model.Goals;
import com.accolite.tfr.DTOmodel.GoalsModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GoalsDTO {
    public Goals modelToEntity(GoalsModel goalsModel){
        ModelMapper mapper =new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        Goals goalsEntity = mapper.map(goalsModel, Goals.class);
        return goalsEntity;
    }

    public GoalsModel entityToModel(Goals goalsEntity){
        ModelMapper mapper =new ModelMapper();
        GoalsModel goalsModel = mapper.map(goalsEntity, GoalsModel.class);
        return goalsModel;
    }

    public List<GoalsModel> allEntitiesToModels (List<Goals> goalsEntities){
        return goalsEntities.stream().map(this::entityToModel).collect(Collectors.toList());
    }

    public List<Goals> allModelsToEntities(List<GoalsModel> goalsModelEntities) {
        return goalsModelEntities.stream().map(this::modelToEntity).collect(Collectors.toList());
    }

}
