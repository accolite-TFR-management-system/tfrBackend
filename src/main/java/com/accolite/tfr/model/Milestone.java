package com.accolite.tfr.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Milestone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "project_id")
    private int project_id;
    @Column(name = "start_date")
    private Date start_date;
    @Column(name = "end_date")
    private Date end_date;
    @Column(name = "status")
    private String status;
    @Column(name = "created_by")
    private int created_by;
    @Column(name = "date_of_add")
    private Date date_of_add;
    @Column(name = "weightage")
    private int weightage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
