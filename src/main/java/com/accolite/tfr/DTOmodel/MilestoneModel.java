package com.accolite.tfr.DTOmodel;

import com.accolite.tfr.entity.Goals;
import com.accolite.tfr.entity.Project;
import com.accolite.tfr.entity.Resource;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class MilestoneModel {

    private int id;

    private String name;

    private Date start_date;

    private Date end_date;

    private String status;

    private Date date_of_add;

    private int weightage;

    private Resource resource;

    private Project project;

    private List<Goals> GoalList;

}
