package com.accolite.tfr.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "Resources")
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    //    private int id;
    @Column(name = "emp_id")
    private int emp_id;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String  name;

    @Column(name = "email")
    private String  email;

    @Column(name = "join_date")
    private Date join_date;

    @Column(name = "leave_date")
    private Date leave_date;

    @Column(name = "skill")
    private String skill;

    @Column(name = "gender")
    private String gender;

    @Column(name = "location")
    private  String location;
//    @Column(name = "designation_id")
//    private int designation_id;
    @Column(name = "remark")
    private  String remark;

    @OneToMany(mappedBy = "ProjectForDep")
    @JsonIgnore
    private List<Project> projectListForDep;

    @OneToMany(mappedBy = "ProjectForLead")
    @JsonIgnore
    private List<Project> projectListForLead;

    @OneToMany(mappedBy = "spoc")
    @JsonIgnore
    private List<Project> spocList;

    @OneToMany(mappedBy = "createdBy")
    @JsonIgnore
    private List<Project> createdByID;

    @ManyToMany(mappedBy = "resource")
    @JsonIgnore
    private List<ResourceFeatureMN> resourceFeatureMN;

    @OneToMany(mappedBy = "resource")
    @JsonIgnore
    private List<Milestone> milestoneList;

    @OneToMany(mappedBy = "createdBy")
    @JsonIgnore
    private List<Clients> createdBy;

    @OneToMany(mappedBy = "addedBy")
    @JsonIgnore
    private List<AccoliteClientMN> addedBy;

    @OneToMany(mappedBy = "modifiedBy")
    @JsonIgnore
    private List<Clients> modifiedBy;

    @OneToMany(mappedBy = "resource")
    @JsonIgnore
    private List<AccoliteClientMN> Resources;

    @OneToMany(mappedBy = "ResourceIdForHistory")
    @JsonIgnore
    private List<ResourceHistory> ResourceIdForHistory;

    @OneToMany(mappedBy = "ResourceHistorycreatedBy")
    @JsonIgnore
    private List<ResourceHistory> ResourceHistorycreatedBy;

    @OneToMany(mappedBy = "CreatedBy")
    @JsonIgnore
    private List<Goals> CreatedBy;


    //    @Column(name = "designation_id")
//    private int designation_id;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType. DETACH})
    @JoinColumn(name="designation_id",referencedColumnName = "id")
    private Designation ResourceList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
