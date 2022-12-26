package com.accolite.tfr.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
@Entity
@Data
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    //    private int id;
    @Column(name = "id")
    private int emp_id;
    @Column(name = "password")
    private String password;
    @Column(name = "name")
    private String  name;
    @Column(name = "email")
    private String  email;
    @Column(name = "project_id")
    private  int project_id;
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
    @Column(name = "designation_id")
    private int designation_id;
    @Column(name = "remark")
    private  String remark;
    @Column(name = "date_of_add")
    private Date date_of_add;//TimeStamp
    @Column(name = "created_by")
    private int created_by;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
