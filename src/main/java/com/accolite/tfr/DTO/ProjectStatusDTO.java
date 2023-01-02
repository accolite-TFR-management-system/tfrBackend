package com.accolite.tfr.DTO;


import com.accolite.tfr.model.ProjectStatus;
import com.accolite.tfr.DTOmodel.ProjectStatusModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProjectStatusDTO {
    public ProjectStatus modelToEntity(ProjectStatusModel projectStatusModel){
        ModelMapper mapper =new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        ProjectStatus projectStatusEntity = mapper.map(projectStatusModel, ProjectStatus.class);
        return projectStatusEntity;
    }

    public ProjectStatusModel entityToModel(ProjectStatus projectStatusEntity){
        ModelMapper mapper =new ModelMapper();
        ProjectStatusModel projectStatusModel = mapper.map(projectStatusEntity, ProjectStatusModel.class);
        return projectStatusModel;
    }

    public List<ProjectStatusModel> allEntitiesToModels (List<ProjectStatus> projectStatusEntities){
        return projectStatusEntities.stream().map(this::entityToModel).collect(Collectors.toList());
    }

    public List<ProjectStatus> allModelsToEntities(List<ProjectStatusModel> projectStatusModelEntities) {
        return projectStatusModelEntities.stream().map(this::modelToEntity).collect(Collectors.toList());
    }
}
