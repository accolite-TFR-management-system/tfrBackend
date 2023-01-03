package com.accolite.tfr.DTO;

import com.accolite.tfr.model.Feature;
import com.accolite.tfr.DTOmodel.FeatureModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FeatureDTO {
    public Feature modelToEntity(FeatureModel featureModel){
        ModelMapper mapper =new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        Feature featureEntity = mapper.map(featureModel, Feature.class);
        return featureEntity;
    }

    public FeatureModel entityToModel(Feature featureEntity){
        ModelMapper mapper =new ModelMapper();
        FeatureModel featureModel = mapper.map(featureEntity, FeatureModel.class);
        return featureModel;
    }

    public List<FeatureModel> allEntitiesToModels (List<Feature> featureEntities){
        return featureEntities.stream().map(this::entityToModel).collect(Collectors.toList());
    }

    public List<Feature> allModelsToEntities(List<FeatureModel> featureModelEntities) {
        return featureModelEntities.stream().map(this::modelToEntity).collect(Collectors.toList());
    }
}
