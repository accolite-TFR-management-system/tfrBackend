package com.accolite.tfr.DTOmodel;

import com.accolite.tfr.entity.Project;
import com.accolite.tfr.entity.Resource;
import lombok.Data;

import java.util.Date;

@Data
public class RiskModel {

    private int id;

    private Project ProjectRisk;

    private String risk;

    private String risk_mitigation;

    private Date start_date;

    private Date end_date;

    private Resource CreatedBy;

    private Date date_of_add;

    private Resource ModifiedBy;

    private Date date_of_modified;
}
