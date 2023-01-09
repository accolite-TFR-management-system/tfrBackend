package com.accolite.tfr.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Entity
@Getter
@Setter
@Table(name = "Resources",uniqueConstraints={@UniqueConstraint(name="Unique_email",columnNames={"email"})})
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
    @Column(name = "email",unique=true)
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
    @OneToMany(mappedBy = "modifiedBy")
    @JsonIgnore
    private List<Project> modifiedByID;
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
    private List<Clients> createdBy;
    @OneToMany(mappedBy = "modifiedBy")
    @JsonIgnore
    private List<Risk> modifiedBy;
    @OneToMany(mappedBy = "riskCreatedBy")
    @JsonIgnore
    private List<Risk> riskCreatedBy;
    @OneToMany(mappedBy = "ResourceIdForHistory")
    @JsonIgnore
    private List<ResourceHistory> ResourceIdForHistory;

    @OneToMany(mappedBy = "ResourceHistorycreatedBy")
    @JsonIgnore
    private List<ResourceHistory> ResourceHistorycreatedBy;

    @OneToMany(mappedBy = "CreatedByGoals")
    @JsonIgnore
    private List<Goals> CreatedByGoals;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType. DETACH})
    @JoinColumn(name="designation_id",referencedColumnName = "id")
    private Designation ResourceList;

    @OneToMany(mappedBy = "InvoiceHistoryCreatedBy")
    @JsonIgnore
    private List<InvoiceHistory> InvoiceHistoryCreatedBy;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "resourcef")
    //@JsonBackReference
    Set<Feature> feature = new HashSet<>();

    @OneToMany(mappedBy = "addedBy")
    @JsonIgnore
    private List<ProjectStatus> addedByID;

    public Set<Feature> getFeature() {
        return feature;
    }

    public void setFeature(Set<Feature> feature) {
        this.feature = feature;
    }

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "resource")
    //@JsonBackReference
    Set<Project> project = new TreeSet<>();

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "resourcec")
    //@JsonBackReference
    Set<Clients> client = new HashSet<>();
}