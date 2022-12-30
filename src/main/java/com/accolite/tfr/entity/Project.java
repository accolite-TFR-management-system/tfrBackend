package com.accolite.tfr.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name="project_name")
    private String name;
    @Column(name="start_date")
    private Date start_date;
    @Column(name="end_date")
    private Date end_date;
    @Column(name="rag_status")
    private  String rag_status;
    @Column(name="sow")
    private int sow;
    @Column(name="total_resource")
    private int total_resource;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType. DETACH})
    @JoinColumn(name="department_id",referencedColumnName = "id")
    private Organisation department;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType. DETACH})
    @JoinColumn(name="super_department_id",referencedColumnName = "id")
    private Organisation superDepartment;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType. DETACH})
    @JoinColumn(name="division_id",referencedColumnName = "id")
    private Organisation division;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType. DETACH})
    @JoinColumn(name="client_id",referencedColumnName = "id")
    private Clients Client;
//    @Column(name="client_id")
//    private int client_id;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType. DETACH})
    @JoinColumn(name="department_head_id",referencedColumnName = "id")
    private Resource ProjectForDep;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType. DETACH})
    @JoinColumn(name="resource_lead_id",referencedColumnName = "id")
    private Resource ProjectForLead;

//    @Column(name="resource_lead_id")
//    private int resource_lead_id;
    @Column(name="remarks")
    private String remarks;
    @Column(name="parent_id")
    private int parent_id;
    @Column(name="current_pointer")
    private  int current_pointer;
    @Column(name="date_of_add")
    private Date date_of_add;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType. DETACH})
    @JoinColumn(name="created_by",referencedColumnName = "id")
    private Resource createdBy;
    @Column(name="invoicing_status")
    private String invoicing_status;
//

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType. DETACH})
    @JoinColumn(name="spoc_id",referencedColumnName = "id")
    private Resource spoc;
    @OneToMany(mappedBy = "project")
    @JsonIgnore
    private List<Milestone> milestoneList;
    @OneToMany(mappedBy = "ResourceHistoryProject")
    @JsonIgnore
    private List<ResourceHistory> ResourceHistoryProject;
    @OneToMany(mappedBy = "ProjectRisk")
    @JsonIgnore
    private List<Risk> ProjectRisk;
    @OneToMany(mappedBy = "CreatedBy")
    @JsonIgnore
    private List<Risk> CreatedBy;
    @OneToMany(mappedBy = "ModifiedBy")
    @JsonIgnore
    private List<Risk> ModifiedBy;


    @OneToMany(mappedBy = "Project")
//    @JsonBackReference(value="ProjectForDep")
    @JsonIgnore
    private List<ProjectStatus> listOfStatus;

}
