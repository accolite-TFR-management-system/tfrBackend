package com.accolite.tfr.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ResourceHistoryDto {
    private String resource_name;
    private Date start_date;
    private Date end_date;
    private String remark;
    private int designation_id;
    private  int project_id;
    private  Date date_of_add;
    private  int created_by;
}
