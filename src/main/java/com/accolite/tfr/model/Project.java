package com.accolite.tfr.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name="project_name")
    private String name;
    @Column(name="start_date")
    private Date start_date;
    @Column(name="end_date")
    private Date end_date;
    @Column(name="rag_status")
    private  String rag_status;
    @Column(name="sow")
    private int sow;
    @Column(name="total_resource")
    private int total_resource;
    @Column(name="department_id")
    private int department_id;
    @Column(name="super_department_id")
    private int super_department_id;
    @Column(name="division_id")
    private int division_id;
    @Column(name="client_id")
    private int client_id;
    @Column(name="department_head_id")
    private int department_head_id;
    @Column(name="resource_lead_id")
    private int resource_lead_id;
    @Column(name="remarks")
    private String remarks;
    @Column(name="parent_id")
    private int parent_id;
    @Column(name="current_pointer")
    private  int current_pointer;
    @Column(name="date_of_add")
    private Date date_of_add;
    @Column(name="created_by")
    private int created_by;
    @Column(name="invoicing_status")
    private String invoicing_status;
    @Column(name="spoc_id")
    private int spoc_id;

}
