package com.accolite.tfr.DTOmodel;

import com.accolite.tfr.model.Project;
import com.accolite.tfr.model.Resource;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class ClientsModel {

    private int id;

    private String name;

    private String emp_name;

    private String emp_email;
    
    private int emp_id;

    private String client_location;

    private String emp_designation;

    private int emp_id;

    private String client_location;

    private String emp_designation;

    private Date date_of_add;

    private Resource createdBy;

    private Resource modifiedBy;

    private List<Project> clientList;

    private Set<Resource> resourcec = new HashSet<>();

}
