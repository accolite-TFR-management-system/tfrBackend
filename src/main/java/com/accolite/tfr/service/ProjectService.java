package com.accolite.tfr.service;

import com.accolite.tfr.DTOmodel.ProjectModel;
import com.accolite.tfr.model.Project;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProjectService {
    public Project addProject(ProjectModel projectModel);
    public Project getProject(int p_id);
    public List<Project> getAllProjects();

    public ResponseEntity<List<ProjectModel>> getAllProjectSortedByDate();

    public ResponseEntity<ProjectModel> updateProject(ProjectModel projectModel,int projectId);
}
