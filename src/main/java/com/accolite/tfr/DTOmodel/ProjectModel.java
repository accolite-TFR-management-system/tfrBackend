package com.accolite.tfr.DTOmodel;

import com.accolite.tfr.entity.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ProjectModel {
    private int id;

    private String name;

    private Date start_date;

    private Date end_date;

    private  String rag_status;

    private int sow;

    private int total_resource;

    private Organisation department;


    private Organisation superDepartment;

    private Organisation division;

    private Clients Client;

    private Resource ProjectForDep;

    private Resource ProjectForLead;


    private String remarks;

    private int parent_id;

    private  int current_pointer;

    private Date date_of_add;

    private Resource createdBy;

    private String invoicing_status;

    private Resource spoc;

    private List<Milestone> milestoneList;

    private List<ResourceHistory> ResourceHistoryProject;

    private List<Risk> ProjectRisk;

    private List<Risk> CreatedBy;

    private List<Risk> ModifiedBy;

    private List<ProjectStatus> listOfStatus;
}
