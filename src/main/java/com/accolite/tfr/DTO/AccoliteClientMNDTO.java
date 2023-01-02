package com.accolite.tfr.DTO;

import com.accolite.tfr.model.AccoliteClientMN;
import com.accolite.tfr.DTOmodel.AccoliteClientMNModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AccoliteClientMNDTO {

    public AccoliteClientMN modelToEntity(AccoliteClientMNModel accoliteClientMNModel){
        ModelMapper mapper =new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        AccoliteClientMN accoliteClientMNEntity = mapper.map(accoliteClientMNModel, AccoliteClientMN.class);
        return accoliteClientMNEntity;
    }

    public AccoliteClientMNModel entityToModel(AccoliteClientMN accoliteClientMNEntity){
        ModelMapper mapper =new ModelMapper();
        AccoliteClientMNModel accoliteClientMNModel  = mapper.map(accoliteClientMNEntity, AccoliteClientMNModel.class);
        return accoliteClientMNModel;
    }

    public List<AccoliteClientMNModel> allEntitiesToModels (List<AccoliteClientMN> accoliteClientMNEntities){
        return accoliteClientMNEntities.stream().map(this::entityToModel).collect(Collectors.toList());
    }


}
