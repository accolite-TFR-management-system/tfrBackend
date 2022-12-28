package com.accolite.tfr.service;


import com.accolite.tfr.dto.ProjectStatusDto;
import com.accolite.tfr.model.ProjectStatus;

public interface ProjectStatusService {

    public ProjectStatus addProjectStatus(ProjectStatusDto orgDto);
    public ProjectStatusDto mapToDto(ProjectStatus org);
    public ProjectStatus mapToEntity(ProjectStatusDto od);
}
