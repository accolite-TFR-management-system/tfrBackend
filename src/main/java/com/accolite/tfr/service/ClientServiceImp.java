package com.accolite.tfr.service;

import com.accolite.tfr.dto.ClientDto;
import com.accolite.tfr.model.Clients;
import com.accolite.tfr.repository.ClientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImp implements ClientsService{

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    public ModelMapper modelMapper;

    public Clients addClients(ClientDto od) {
        Clients client = this.mapToEntity(od);
        return this.clientRepository.save(client);
    }

    public ClientDto mapToDto(Clients org) {
        ClientDto od = modelMapper.map(org,ClientDto.class);
        return od;
    }

    public Clients mapToEntity(ClientDto od) {
        Clients org = modelMapper.map(od, Clients.class);
        return org;
    }
}
