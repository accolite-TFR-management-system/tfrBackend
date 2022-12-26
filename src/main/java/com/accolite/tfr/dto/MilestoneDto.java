package com.accolite.tfr.dto;

import lombok.Data;

import java.util.Date;

@Data
public class MilestoneDto {
    private String name;
    private int project_id;
    private Date start_date;
    private Date end_date;
    private String status;
    private int created_by;
    private Date date_of_add;
    private int weightage;
}
