package com.accolite.tfr.DTO;

import com.accolite.tfr.entity.Organisation;
import com.accolite.tfr.DTOmodel.OrganisationModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrganisationDTO {
    public Organisation modelToEntity(OrganisationModel organisationModel){
        ModelMapper mapper =new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        Organisation organisationEntity = mapper.map(organisationModel, Organisation.class);
        return organisationEntity;
    }

    public OrganisationModel entityToModel(Organisation organisationEntity){
        ModelMapper mapper =new ModelMapper();
        OrganisationModel organisationModel = mapper.map(organisationEntity, OrganisationModel.class);
        return organisationModel;
    }

    public List<OrganisationModel> allEntitiesToModels (List<Organisation> organisationEntities){
        return organisationEntities.stream().map(this::entityToModel).collect(Collectors.toList());
    }

    public List<Organisation> allModelsToEntities(List<OrganisationModel> organisationModelEntities) {
        return organisationModelEntities.stream().map(this::modelToEntity).collect(Collectors.toList());
    }
}
