package com.accolite.tfr.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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
    @Column(name = "date_of_add")
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

    @OneToMany(mappedBy = "Client")
//    @JsonBackReference(value="ProjectForLead")
    private List<Project> clientList;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
