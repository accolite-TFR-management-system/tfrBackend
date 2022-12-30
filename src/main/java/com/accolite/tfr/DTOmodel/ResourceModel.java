package com.accolite.tfr.DTOmodel;

import com.accolite.tfr.entity.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

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

    private List<Project> spocList;

    private List<Project> projectcreatedByID;

    private List<ResourceFeatureMN> resourceFeatureMN;

    private List<Milestone> milestoneList;

    private List<Resource> resourcecreatedBy;

    private List<AccoliteClientMN> addedBy;

    private List<Resource> modifiedBy;

    private List<AccoliteClientMN> Resources;

    private List<ResourceHistory> ResourceIdForHistory;

    private List<ResourceHistory> ResourceHistorycreatedBy;

    private List<Goals> CreatedBy;

    private Designation ResourceList;
}
