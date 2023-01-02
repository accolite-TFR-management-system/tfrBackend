package com.accolite.tfr.service;


import com.accolite.tfr.DTOmodel.ClientsModel;
import com.accolite.tfr.model.Clients;

public interface ClientsService {
    public Clients addClients(ClientsModel clientsModel);
    public Clients getProject(int c_id);

    public Clients getClient(int c_id);

}
