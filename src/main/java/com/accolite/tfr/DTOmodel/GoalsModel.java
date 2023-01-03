package com.accolite.tfr.DTOmodel;

import com.accolite.tfr.model.Milestone;
import com.accolite.tfr.model.Resource;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
public class GoalsModel {

    private int id;

    private Milestone Milestone;

    private String name;

    private String goal_description;
    private String goal_status;

    private Date date_of_add;

    private Date start_date;

    private Date end_date;

    private Resource CreatedBy;

}
