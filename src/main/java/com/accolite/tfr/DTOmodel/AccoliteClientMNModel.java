package com.accolite.tfr.DTOmodel;

import com.accolite.tfr.model.Clients;
import com.accolite.tfr.model.Resource;
import lombok.Data;

import java.util.Date;

@Data
public class AccoliteClientMNModel {

    private int id;

    private Boolean status;

    private Date date_of_add;

    private Clients Client;

    private Resource addedBy;

    private Resource resource;
}
