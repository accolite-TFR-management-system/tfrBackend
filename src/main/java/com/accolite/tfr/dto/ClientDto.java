package com.accolite.tfr.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ClientDto {
    private String name;
    private String emp_name;
    private String emp_email;
    private Date date_of_add;
    private int created_by;
    private int modified_by;
    private Date date_of_modified;
}
