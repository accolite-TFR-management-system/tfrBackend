package com.accolite.tfr.DTO;

import com.accolite.tfr.model.ResourceHistory;
import com.accolite.tfr.DTOmodel.ResourceHistoryModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ResourceHistoryDTO {
    public ResourceHistory modelToEntity(ResourceHistoryModel resourceHistoryModel){
        ModelMapper mapper =new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        ResourceHistory resourceHistoryEntity = mapper.map(resourceHistoryModel, ResourceHistory.class);
        return resourceHistoryEntity;
    }

    public ResourceHistoryModel entityToModel(ResourceHistory resourceHistoryEntity){
        ModelMapper mapper =new ModelMapper();
        ResourceHistoryModel resourceHistoryModel = mapper.map(resourceHistoryEntity, ResourceHistoryModel.class);
        return resourceHistoryModel;
    }

    public List<ResourceHistoryModel> allEntitiesToModels (List<ResourceHistory> resourceHistoryEntities){
        return resourceHistoryEntities.stream().map(this::entityToModel).collect(Collectors.toList());
    }

    public List<ResourceHistory> allModelsToEntities(List<ResourceHistoryModel> resourceHistoryModelEntities) {
        return resourceHistoryModelEntities.stream().map(this::modelToEntity).collect(Collectors.toList());
    }
}
