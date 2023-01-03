package com.accolite.tfr.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
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
//    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType. DETACH})
//    @JoinColumn(name="client_id",referencedColumnName = "id")
//    private Clients client;
////    @Column(name="client_id")
////    private int client_id;
//    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType. DETACH})
//    @JoinColumn(name="department_head_id",referencedColumnName = "id")
//    private Resource dephead;
//    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType. DETACH})
//    @JoinColumn(name="resource_lead_id",referencedColumnName = "id")
//    private Resource proLead;

//    @Column(name="resource_lead_id")
//    private int resource_lead_id;
    @Column(name="remarks")
    private String remarks;
    @Column(name="parent_id")
    private int parent_id;
    @Column(name="current_pointer")
    private  int current_pointer;
    @Column(name = "date_of_add",nullable = false, updatable = false)
    @CreationTimestamp
    private Date date_of_add;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType. DETACH})
    @JoinColumn(name="created_by",referencedColumnName = "id")
    private Resource createdBy;
    @Column(name="invoicing_status")
    @JsonIgnore
    private String invoicing_status;
//

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType. DETACH})
    @JoinColumn(name="spoc_id",referencedColumnName = "id")
    private Resource spoc;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType. DETACH})
    @JoinColumn(name="department_head_id",referencedColumnName = "id")
    private Resource depHead;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType. DETACH})
    @JoinColumn(name="resource_lead_id",referencedColumnName = "id")
    private Resource projectLead;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType. DETACH})
    @JoinColumn(name="modified_by",referencedColumnName = "id")
    private Resource ModifiedBy;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType. DETACH})
    @JoinColumn(name="client_id",referencedColumnName = "id")
    private Clients client;
    @OneToMany(mappedBy = "project")
    @JsonIgnore
    private List<Milestone> milestoneList;
    @OneToMany(mappedBy = "ResourceHistoryProject")
    @JsonIgnore
    private List<ResourceHistory> ResourceHistoryProject;
    @OneToMany(mappedBy = "ProjectRisk")
    @JsonIgnore
    private List<Risk> ProjectRisk;
//    @OneToMany(mappedBy = "RiskCreatedBy")
//    @JsonIgnore
//    private List<Risk> RiskCreatedBy;
//    @OneToMany(mappedBy = "ModifiedBy")
//    @JsonIgnore
//    private List<Resource> ModifiedBy;


    @OneToMany(mappedBy = "project")
    @JsonIgnore
    private List<ProjectStatus> listOfStatus;


    @ManyToMany(fetch = FetchType.LAZY,cascade = { CascadeType.ALL })
    @JoinTable(
            name = "resource_project_mn_table",
            joinColumns = { @JoinColumn(name = "project_id") },
            inverseJoinColumns = { @JoinColumn(name = "resource_id") }
    )
    //@JsonManagedReference
    private Set<Resource> resource = new HashSet<>();

//    @JsonIgnore
    public Set<Resource> getResource() {
        return resource;
    }

    public void setResource(Set<Resource> project) {
        this.resource = project;
    }
}
