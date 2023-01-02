package com.accolite.tfr.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Resources")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property="id")

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
    @OneToMany(mappedBy = "depHead")
    @JsonIgnore
    private List<Project> projectListForDep;
    @OneToMany(mappedBy = "projectLead")
    @JsonIgnore
    private List<Project> projectListForLead;
    @OneToMany(mappedBy = "createdBy")
    @JsonIgnore
    private List<Project> createdByID;
    @OneToMany(mappedBy = "spoc")
    @JsonIgnore
    private List<Project> spocList;

//    @ManyToMany(mappedBy = "resource")
//    @JsonIgnore
//    private List<ResourceFeatureMN> resourceFeatureMN;
    @OneToMany(mappedBy = "resource")
    @JsonIgnore
    private List<Milestone> milestoneList;
    @OneToMany(mappedBy = "createdBy")
    @JsonIgnore
    private List<Resource> createdBy;
    @OneToMany(mappedBy = "addedBy")
    @JsonIgnore
    private List<AccoliteClientMN> addedBy;
    @OneToMany(mappedBy = "modifiedBy")
    @JsonIgnore
    private List<Risk> modifiedBy;
    @OneToMany(mappedBy = "riskCreatedBy")
    @JsonIgnore
    private List<Risk> riskCreatedBy;

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

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType. DETACH})
    @JoinColumn(name="designation_id",referencedColumnName = "id")
    private Designation ResourceList;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "resourcef")
    //@JsonBackReference
    Set<Feature> feature = new HashSet<>();

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "resource")
    //@JsonBackReference
    Set<Project> project = new HashSet<>();

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "resourcec")
    //@JsonBackReference
    Set<Clients> client = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
