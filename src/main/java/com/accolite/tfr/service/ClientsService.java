package com.accolite.tfr.service;


import java.util.List;

import com.accolite.tfr.DTOmodel.ClientsModel;
import com.accolite.tfr.model.Clients;
import com.accolite.tfr.model.Designation;

public interface ClientsService {
    public Clients addClients(ClientsModel clientsModel);
    public Clients getProject(int c_id);
    public Clients getClient(int c_id);
    public List<Clients> getallclients();


}
