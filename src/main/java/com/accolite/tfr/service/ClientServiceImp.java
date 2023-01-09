package com.accolite.tfr.service;

import com.accolite.tfr.DTO.ClientsDTO;
import com.accolite.tfr.exception.Exception;
import com.accolite.tfr.DTOmodel.ClientsModel;
import com.accolite.tfr.model.Clients;
import com.accolite.tfr.model.Designation;
import com.accolite.tfr.repository.ClientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImp implements ClientsService{

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    public ModelMapper modelMapper;

    @Autowired(required = false)
    private ClientsDTO clientsDTO;

    public Clients addClients(ClientsModel clientsModel) {
       Clients client = this.clientsDTO.modelToEntity(clientsModel);
        return this.clientRepository.save(client);
    }

    public Clients getProject(int c_id) {

        Optional<Clients> clients = Optional.ofNullable(this.clientRepository.findClientsById(c_id));
//        Project projectModel=projectDTO.modelToEntity(project);
        if(clients.isPresent()) {
            return clients.get();
        }
        else {
            throw new Exception("Project not found");
        }
    }

    public Clients getClient(int c_id) {
        Optional<Clients> client = this.clientRepository.findById(c_id);
        if(client.isPresent()){
            return client.get();
        }
        else {
            throw new Exception("Client not found");
        }
    }
    
    public List<Clients> getallclients(){
    	return this.clientRepository.findAll();
    }

}
