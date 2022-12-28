package com.accolite.tfr.dto;

import com.accolite.tfr.model.Organisation;
import lombok.Data;

@Data
public class OrganisationDto {
//    private int client_id;
    private String name;
    private String department_type;
    private int grand_parent_id;
    private int parent_id;
    //private Organisation org;

//    public OrganisationDto(Organisation org) {
//        this.org = org;
//    }
}
