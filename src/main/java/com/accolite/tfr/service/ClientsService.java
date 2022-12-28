package com.accolite.tfr.service;


import com.accolite.tfr.dto.ClientDto;
import com.accolite.tfr.model.Clients;

public interface ClientsService {
    public Clients addClients(ClientDto orgDto);
    public ClientDto mapToDto(Clients org);
    public Clients mapToEntity(ClientDto od);
}
