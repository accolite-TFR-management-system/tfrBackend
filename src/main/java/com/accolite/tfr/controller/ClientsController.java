package com.accolite.tfr.controller;


import com.accolite.tfr.DTO.ClientsDTO;
import com.accolite.tfr.model.Clients;
import com.accolite.tfr.model.Designation;
import com.accolite.tfr.DTOmodel.ClientsModel;
import com.accolite.tfr.DTOmodel.DesignationModel;
import com.accolite.tfr.repository.ClientRepository;
import com.accolite.tfr.service.ClientServiceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins="http://localhost:4200")
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

    @GetMapping("/getClient/{c_id}")
    private ResponseEntity<ClientsModel> getClient(@PathVariable int c_id){
        Clients newClient = this.clientServiceImp.getClient(c_id);
        ClientsModel clientsModel=this.clientsDTO.entityToModel(newClient);
        return  ResponseEntity.ok().body(clientsModel);
    }

    @GetMapping("/getClientByProjectID/{c_id}")
    private ResponseEntity<ClientsModel> getClientByProjectID(@PathVariable int c_id){
        Clients newClient = this.clientServiceImp.getProject(c_id);
        ClientsModel clientsModel=this.clientsDTO.entityToModel(newClient);
        return  ResponseEntity.ok().body(clientsModel);
    }

    @GetMapping("/getclient")
    private ResponseEntity<List<ClientsModel>> getallclient(){
        List<Clients> clients = this.clientServiceImp.getallclients();
        List<ClientsModel> clientsmodel=clientsDTO.allEntitiesToModels(clients);
        return ResponseEntity.ok().body(clientsmodel);
    }

}
