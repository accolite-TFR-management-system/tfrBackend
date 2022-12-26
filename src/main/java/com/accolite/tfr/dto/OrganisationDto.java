package com.accolite.tfr.dto;

import lombok.Data;

@Data
public class OrganisationDto {
    private int client_id;
    private String name;
    private String department_type;
    private int grand_parent_id;
    private int parent_id;
}
