package com.accolite.tfr.DTO;
;
import com.accolite.tfr.entity.Designation;
import com.accolite.tfr.DTOmodel.DesignationModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DesignationDTO {
    public Designation modelToEntity(DesignationModel designationModel){
        ModelMapper mapper =new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        Designation designationEntity = mapper.map(designationModel, Designation.class);
        return designationEntity;
    }

    public DesignationModel entityToModel(Designation designationEntity){
        ModelMapper mapper =new ModelMapper();
        DesignationModel designationModel = mapper.map(designationEntity, DesignationModel.class);
        return designationModel;
    }

    public List<DesignationModel> allEntitiesToModels (List<Designation> designationEntities){
        return designationEntities.stream().map(this::entityToModel).collect(Collectors.toList());
    }

    public List<Designation> allModelsToEntities(List<DesignationModel> designationModelEntities) {
        return designationModelEntities.stream().map(this::modelToEntity).collect(Collectors.toList());
    }

}
