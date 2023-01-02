package com.accolite.tfr.DTOmodel;

import com.accolite.tfr.model.Project;
import lombok.Data;

import java.util.List;

@Data
public class OrganisationModel {
    private int id;

    private String name;

    private String department_type;

    private int grand_parent_id;

    private int parent_id;

    private List<Project> departmentList;

    private List<Project> superDepartmentList;

    private List<Project> divisionList;
}
