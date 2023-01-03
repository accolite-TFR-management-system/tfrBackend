package com.accolite.tfr.controller;


import com.accolite.tfr.DTO.ProjectDTO;
import com.accolite.tfr.model.Project;
import com.accolite.tfr.DTOmodel.ProjectModel;
import com.accolite.tfr.repository.ProjectRepository;
import com.accolite.tfr.service.ProjectServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/tfr")
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    public ProjectServiceImp projectServiceImp;
    @Autowired(required = false)
    public ProjectDTO projectDTO;

    @PostMapping("/addProject")
    private ResponseEntity<ProjectModel> addProject(@RequestBody ProjectModel projectModel) {
        Project project = this.projectServiceImp.addProject(projectModel);
        ProjectModel projectModel1=projectDTO.entityToModel(project);
        return ResponseEntity.ok().body(projectModel1);
    }

    @GetMapping("/getProject/{p_id}")
    private ResponseEntity<ProjectModel> getProject(@PathVariable int p_id){
        Project newProject = this.projectServiceImp.getProject(p_id);
        ProjectModel projectModel=projectDTO.entityToModel(newProject);
        return ResponseEntity.ok().body(projectModel);
    }

    @GetMapping("/getAllProjects")
    private ResponseEntity<List<ProjectModel>> getAllProjects(){
        List<Project> newProjectList = this.projectServiceImp.getAllProjects();
        List<ProjectModel> projectModelList=projectDTO.allEntitiesToModels(newProjectList);
        return ResponseEntity.ok().body(projectModelList);
    }

}
