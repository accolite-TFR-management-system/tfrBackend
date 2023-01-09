package com.accolite.tfr.DTOmodel;

import com.accolite.tfr.model.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Getter
@Setter
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
    private List<Project> modifiedByID;
    private List<Project> spocList;
    private List<Milestone> milestoneList;
    private List<Clients> createdBy;
    private List<Risk> modifiedBy;
    private List<Risk> riskCreatedBy;
    private List<ResourceHistory> ResourceIdForHistory;
    private List<ResourceHistory> ResourceHistorycreatedBy;
    private List<Goals> CreatedByGoals;
    private Designation ResourceList;
    private List<InvoiceHistory> InvoiceHistoryCreatedBy;
    Set<Feature> feature = new HashSet<>();
    private List<ProjectStatus> addedByID;
    Set<Project> project = new TreeSet<>();
    Set<Clients> client = new HashSet<>();
}
