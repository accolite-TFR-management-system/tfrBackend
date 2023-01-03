package com.accolite.tfr.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name="clients")
public class Clients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "client_name")
    private String name;
    @Column(name = "emp_name")
    private String emp_name;
    @Column(name = "emp_email")
    private String emp_email;
    @Column(name = "date_of_add",nullable = false, updatable = false)
    @CreationTimestamp
    private Date date_of_add;
//    @Column(name = "created_by")
//    private int created_by;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType. DETACH})
    @JoinColumn(name="created_by",referencedColumnName = "id")
    private Resource createdBy;
//    @Column(name = "modified_by")
//    private int modified_by;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType. DETACH})
    @JoinColumn(name="modified_by",referencedColumnName = "id")
    private Resource modifiedBy;
//    @Column(name = "date_of_modify")
//    private Date date_of_modified;

    @OneToMany(mappedBy = "client")
    @JsonIgnore
    private List<Project> clientList;

    @JsonIgnore
    public Set<Resource> getResourcec() {
        return resourcec;
    }

    public void setResourcec(Set<Resource> resourcec) {
        this.resourcec = resourcec;
    }

    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.MERGE, CascadeType. DETACH})
    @JoinTable(
            name = "resource_client_mn_table",
            joinColumns = { @JoinColumn(name = "client_id") },
            inverseJoinColumns = { @JoinColumn(name = "resource_id") }
    )
    //@JsonManagedReference
    private Set<Resource> resourcec = new HashSet<>();


//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
}
