package com.accolite.tfr.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "project_status")
public class ProjectStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType. DETACH})
    @JoinColumn(name="project_id",referencedColumnName = "id")
    private Project project;
    @Column(name = "status_type")
    private  String status_type;
    @Column(name = "status")
    private String status;
    @Column(name = "date_of_add",nullable = false, updatable = false)
    @CreationTimestamp
    private Date date_of_add;

    @Column(name = "added_by")
    private int added_by;


//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
}
