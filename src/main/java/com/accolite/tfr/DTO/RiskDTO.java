package com.accolite.tfr.DTO;

import com.accolite.tfr.entity.Risk;
import com.accolite.tfr.DTOmodel.RiskModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RiskDTO {
    public Risk modelToEntity(RiskModel riskModel){
        ModelMapper mapper =new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        Risk riskEntity = mapper.map(riskModel, Risk.class);
        return riskEntity;
    }

    public RiskModel entityToModel(Risk riskEntity){
        ModelMapper mapper =new ModelMapper();
        RiskModel riskModel = mapper.map(riskEntity, RiskModel.class);
        return riskModel;
    }

    public List<RiskModel> allEntitiesToModels (List<Risk> riskEntities){
        return riskEntities.stream().map(this::entityToModel).collect(Collectors.toList());
    }

    public List<Risk> allModelsToEntities(List<RiskModel> riskModelEntities) {
        return riskModelEntities.stream().map(this::modelToEntity).collect(Collectors.toList());
    }
}
