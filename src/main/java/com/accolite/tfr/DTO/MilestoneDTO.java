package com.accolite.tfr.DTO;

import com.accolite.tfr.entity.Milestone;
import com.accolite.tfr.DTOmodel.MilestoneModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MilestoneDTO {
    public Milestone modelToEntity(MilestoneModel milestoneModel){
        ModelMapper mapper =new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        Milestone milestoneEntity = mapper.map(milestoneModel, Milestone.class);
        return milestoneEntity;
    }

    public MilestoneModel entityToModel(Milestone milestoneEntity){
        ModelMapper mapper =new ModelMapper();
        MilestoneModel milestioneModel = mapper.map(milestoneEntity, MilestoneModel.class);
        return milestioneModel;
    }

    public List<MilestoneModel> allEntitiesToModels (List<Milestone> milestoneEntities){
        return milestoneEntities.stream().map(this::entityToModel).collect(Collectors.toList());
    }

    public List<Milestone> allModelsToEntities(List<MilestoneModel> milestoneModelEntities) {
        return milestoneModelEntities.stream().map(this::modelToEntity).collect(Collectors.toList());
    }
}
