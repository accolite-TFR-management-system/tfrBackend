package com.accolite.tfr.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name="risk")
public class Risk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
//    @Column(name = "project_id")
//    private int project_id;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType. DETACH})
    @JoinColumn(name="project_id",referencedColumnName = "id")
    private Project ProjectRisk;

    @Column(name = "risk")
    private String risk;
    @Column(name = "risk_mitigation")
    private String risk_mitigation;
    @Column(name = "start_date")
    private Date start_date;
    @Column(name = "end_date")
    private Date end_date;
//    @Column(name = "created_by")
//    private int created_by;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType. DETACH})
    @JoinColumn(name="created_by",referencedColumnName = "id")
    private Resource riskCreatedBy;

    @Column(name = "date_of_add",nullable = false, updatable = false)
    @CreationTimestamp
    private Date date_of_add;
//    @Column(name = "modified_by")
//    private int modified_by;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType. DETACH})
    @JoinColumn(name="modified_by",referencedColumnName = "id")
    private Resource modifiedBy;

    @Column(name = "date_of_modified")
    private Date date_of_modified;

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
}
