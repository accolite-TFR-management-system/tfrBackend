package com.accolite.tfr.service;

import com.accolite.tfr.DTOmodel.ProjectModel;
import com.accolite.tfr.model.Project;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface ProjectService {
    public Project addProject(ProjectModel projectModel);
    public Project getProject(int p_id);
    public List<Project> getAllProjects();
    public ResponseEntity<List<ProjectModel>> getAllProjectSortedByDate();
//    public List<Project> getProjectByCid(int c_id);
    public ResponseEntity<ProjectModel> updateProject(ProjectModel projectModel,int projectId);

    public ResponseEntity<List<Project>> getProjectByOrgId(int o_id);

    public ResponseEntity<?> updateProj(int projectId, Map<Object,Object> fields);
    public List<Project> getProjectByCid(int c_id);


}
