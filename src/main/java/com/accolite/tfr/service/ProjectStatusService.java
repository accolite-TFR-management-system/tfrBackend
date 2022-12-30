package com.accolite.tfr.service;


import com.accolite.tfr.DTOmodel.ProjectStatusModel;
import com.accolite.tfr.entity.ProjectStatus;

public interface ProjectStatusService {

    public ProjectStatus addProjectStatus(ProjectStatusModel orgDto);
}
