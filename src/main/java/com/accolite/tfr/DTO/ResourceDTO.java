package com.accolite.tfr.DTO;

import com.accolite.tfr.model.Resource;
import com.accolite.tfr.DTOmodel.ResourceModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@Component
public class ResourceDTO {
    public Resource modelToEntity(ResourceModel resourceModel){
        ModelMapper mapper =new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        Resource resourceEntity = mapper.map(resourceModel, Resource.class);
        return resourceEntity;
    }

    public ResourceModel entityToModel(Resource resourceEntity){
        ModelMapper mapper =new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        ResourceModel resourceModel = mapper.map(resourceEntity, ResourceModel.class);
        return resourceModel;
    }

    public List<ResourceModel> allEntitiesToModels (List<Resource> resourceEntities){
        return resourceEntities.stream().map(this::entityToModel).collect(Collectors.toList());
    }

    public List<Resource> allModelsToEntities(List<ResourceModel> resourceModelEntities) {
        return resourceModelEntities.stream().map(this::modelToEntity).collect(Collectors.toList());
    }

    public Set<ResourceModel> allEntitiesToModelsSet(Set<Resource> resources) {
        return resources.stream().map(this::entityToModel).collect(Collectors.toSet());
    }

}
