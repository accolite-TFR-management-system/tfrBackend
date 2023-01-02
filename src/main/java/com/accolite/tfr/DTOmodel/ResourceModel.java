package com.accolite.tfr.DTOmodel;

import com.accolite.tfr.model.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class ResourceModel {

    private int id;
    private int emp_id;
    private String password;
    private String  name;
    private String  email;
    private Date join_date;
    private Date leave_date;
    private String skill;
    private String gender;
    private  String location;
    private  String remark;
    private List<Project> projectListForDep;
    private List<Project> projectListForLead;
    private List<Project> createdByID;
    private List<Project> spocList;
    private List<Milestone> milestoneList;
    private List<Resource> createdBy;
    private List<AccoliteClientMN> addedBy;
    private List<Risk> modifiedBy;
    private List<Risk> riskCreatedBy;
    private List<AccoliteClientMN> Resources;
    private List<ResourceHistory> ResourceIdForHistory;
    private List<ResourceHistory> ResourceHistorycreatedBy;
    private List<Goals> CreatedBy;
    private Designation ResourceList;
    Set<Feature> feature = new HashSet<>();
    Set<Project> project = new HashSet<>();
    Set<Clients> client = new HashSet<>();

}
