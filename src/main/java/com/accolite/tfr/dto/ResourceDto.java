package com.accolite.tfr.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ResourceDto {

    private int emp_id;
    private String  name;
    private String  email;
    private  Long project_id;
    private Date join_date;
    private Date leave_date;
    private String skill;
    private String gender;
    private  String location;
    private Long designation_id;
    private  String remark;
    private Date date_of_add;//TimeStamp
    private Long created_by;
}
