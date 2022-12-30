package com.accolite.tfr.DTOmodel;

import com.accolite.tfr.entity.Milestone;
import com.accolite.tfr.entity.Resource;
import lombok.Data;

import java.util.Date;

@Data
public class GoalsModel {
    private int id;

    private Milestone Goals;

    private String name;

    private String goal_description;

    private String goal_status;

    private Date date_of_add;

    private Date start_date;

    private Date end_date;

    private Resource CreatedBy;
}
