package com.accolite.tfr.service;

import com.accolite.tfr.dto.ProjectDto;
import com.accolite.tfr.model.Project;

public interface ProjectService {
    public Project addProject(ProjectDto projectDto);
    public ProjectDto mapToDto(Project org);
    public Project mapToEntity(ProjectDto od);
}
