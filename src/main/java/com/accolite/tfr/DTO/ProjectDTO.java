package com.accolite.tfr.DTO;

import com.accolite.tfr.model.Project;
import com.accolite.tfr.DTOmodel.ProjectModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProjectDTO {
    public Project modelToEntity(ProjectModel projectModel){
        ModelMapper mapper =new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        Project projectEntity = mapper.map(projectModel, Project.class);
        return projectEntity;
    }

    public ProjectModel entityToModel(Project projectEntity){
        ModelMapper mapper =new ModelMapper();
        ProjectModel projectModel = mapper.map(projectEntity, ProjectModel.class);
        return projectModel;
    }

    public List<ProjectModel> allEntitiesToModels (List<Project> projectEntities){
        return projectEntities.stream().map(this::entityToModel).collect(Collectors.toList());
    }

    public List<Project> allModelsToEntities(List<ProjectModel>projectModelEntities) {
        return projectModelEntities.stream().map(this::modelToEntity).collect(Collectors.toList());
    }
}
