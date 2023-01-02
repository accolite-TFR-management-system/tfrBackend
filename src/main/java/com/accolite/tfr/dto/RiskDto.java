package com.accolite.tfr.dto;

import lombok.Data;

import java.util.Date;

@Data
public class RiskDto {
    private int project_id;
    private String risk;
    private String risk_mitigation;
    private Date start_date;
    private Date end_date;
    private int created_by;
    private Date date_of_add;
    private int modified_by;
    private Date date_of_modified;
}
