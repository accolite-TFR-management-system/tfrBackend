package com.accolite.tfr.DTO;

import com.accolite.tfr.DTOmodel.FeatureModel;
import com.accolite.tfr.model.Clients;
import com.accolite.tfr.DTOmodel.ClientsModel;
import com.accolite.tfr.model.Feature;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ClientsDTO {
    public Clients modelToEntity(ClientsModel clientsModel){
        ModelMapper mapper =new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        Clients clientsEntity = mapper.map(clientsModel, Clients.class);
        return clientsEntity;
    }

    public ClientsModel entityToModel(Clients clientsEntity){
        ModelMapper mapper =new ModelMapper();
        ClientsModel clientsModel = mapper.map(clientsEntity, ClientsModel.class);
        return clientsModel;
    }

    public List<ClientsModel> allEntitiesToModels (List<Clients> clientsEntities){
        return clientsEntities.stream().map(this::entityToModel).collect(Collectors.toList());
    }

    public List<Clients> allModelsToEntities(List<ClientsModel> clientsModelEntities) {
        return clientsModelEntities.stream().map(this::modelToEntity).collect(Collectors.toList());
    }

    public Set<ClientsModel> allEntitiesToModelsSet(Set<Clients> clients) {
        return clients.stream().map(this::entityToModel).collect(Collectors.toSet());
    }
}
