package com.accolite.tfr.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ProjectStatusDto {
    private int id;
    private  int project_id;
    private  String status_type;
    private String status;
    private Date date_of_add;
    private int added_by;
}
