package com.accolite.tfr.service;


import com.accolite.tfr.exception.Exception;
import com.accolite.tfr.DTO.ProjectDTO;
import com.accolite.tfr.DTOmodel.ProjectModel;
import com.accolite.tfr.model.Project;
import com.accolite.tfr.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImp implements ProjectService{
    @Autowired
    public ProjectRepository projectRepository;
    @Autowired(required = false)
    public ProjectDTO projectDTO;

    public Project addProject(ProjectModel projectModel) {
        Project project= this.projectDTO.modelToEntity(projectModel);
        return this.projectRepository.save(project);
    }

    public Project getProject(int p_id) {

        Optional<Project> project = Optional.ofNullable(this.projectRepository.findProjectById(p_id));
//        Project projectModel=projectDTO.modelToEntity(project);
        if(project.isPresent()) {
            return project.get();
        }
        else {
            throw new Exception("Project not found");
        }
    }

    public List<Project> getAllProjects() {
        return this.projectRepository.findAll();
    }

    public ResponseEntity<List<ProjectModel>> getAllProjectSortedByDate() {
        List<Project> projectList = this.projectRepository.findAll() ;
        projectList.sort(Comparator.comparing(Project::getDate_of_add));
        List<ProjectModel> projectModels=this.projectDTO.allEntitiesToModels(projectList);
        return  new ResponseEntity<List<ProjectModel>>(projectModels, HttpStatus.OK);
    }

}
