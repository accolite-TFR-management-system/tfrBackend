package com.accolite.tfr.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class ProjectStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "project_id")
    private  int project_id;
    @Column(name = "status_type")
    private  String status_type;
    @Column(name = "status")
    private String status;
    @Column(name = "date_of_add")
    private Date date_of_add;
    @Column(name = "added_by")
    private int added_by;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
