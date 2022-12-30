package com.accolite.tfr.controller;


import com.accolite.tfr.DTO.ClientsDTO;
import com.accolite.tfr.entity.Clients;
import com.accolite.tfr.DTOmodel.ClientsModel;
import com.accolite.tfr.repository.ClientRepository;
import com.accolite.tfr.service.ClientServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tfr")
public class ClientsController {

    @Autowired
    public ClientRepository clientRepository;
    @Autowired
    public ClientServiceImp clientServiceImp;
    @Autowired(required = false)
    private ClientsDTO clientsDTO;

    @PostMapping("/addClient")
    private ResponseEntity<ClientsModel> addClients(@RequestBody ClientsModel clientsModel) {
        Clients clients = this.clientServiceImp.addClients(clientsModel);
        ClientsModel clientsModel1 = this.clientsDTO.entityToModel(clients);
        return ResponseEntity.ok().body(clientsModel1);
    }

}
