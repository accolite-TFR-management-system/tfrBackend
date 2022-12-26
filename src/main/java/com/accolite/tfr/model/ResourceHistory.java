package com.accolite.tfr.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class ResourceHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "feature_id")
    private int resource_id;
    @Column(name = "resource_name")
    private String resource_name;
    @Column(name = "start_date")
    private Date start_date;
    @Column(name = "end_date")
    private Date end_date;
    @Column(name = "remark")
    private String remark;
    @Column(name = "designation_id")
    private int designation_id;
    @Column(name = "project_id")
    private  int project_id;
    @Column(name = "date_of_add")
    private  Date date_of_add;
    @Column(name = "created_by")
    private  int created_by;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
