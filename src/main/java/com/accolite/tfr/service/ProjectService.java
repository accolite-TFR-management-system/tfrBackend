package com.accolite.tfr.service;

import com.accolite.tfr.DTOmodel.ProjectModel;
import com.accolite.tfr.model.Project;

import java.util.List;

public interface ProjectService {
    public Project addProject(ProjectModel projectModel);
    public Project getProject(int p_id);
    public List<Project> getAllProjects();
}
