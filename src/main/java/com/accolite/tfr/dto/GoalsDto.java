package com.accolite.tfr.dto;

import lombok.Data;

import java.util.Date;

@Data
public class GoalsDto {
    private int milestone_id;
    private String name;
    private String goal_description;
    private String goal_status;
    private Date date_of_add;
    private Date start_date;
    private Date end_date;
    private int created_by;
}
