package com.accolite.tfr.DTOmodel;

import com.accolite.tfr.entity.Project;
import com.accolite.tfr.entity.Resource;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ClientsModel {

    private int id;

    private String name;

    private String emp_name;

    private String emp_email;

    private Date date_of_add;

    private Resource createdBy;

    private Resource modifiedBy;

    private List<Project> clientList;
}
