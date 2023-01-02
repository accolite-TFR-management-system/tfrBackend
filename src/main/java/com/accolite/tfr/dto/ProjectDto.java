package com.accolite.tfr.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ProjectDto {
    private String name;
    private Date start_date;
    private Date end_date;
    private  String rag_status;
    private int sow;
    private int total_resource;
    private int department_id;
    private int super_department_id;
    private int division_id;
    private int client_id;
    private int department_head_id;
    private int resource_lead_id;
    private String remarks;
    private int parent_id;
    private  int current_pointer;
    private Date date_of_add;
    private int created_by;
    private String invoicing_status;
    private int spoc_id;
}
