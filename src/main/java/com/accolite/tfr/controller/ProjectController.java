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
import java.util.Map;

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
    @GetMapping("/getProjectByCid/{c_id}")
    private ResponseEntity<List<ProjectModel>> getProjectByCid(@PathVariable("c_id") int c_id){
        List<Project> newProject = this.projectServiceImp.getProjectByCid(c_id);
        List<ProjectModel> projectModel=projectDTO.allEntitiesToModels(newProject);
        return ResponseEntity.ok().body(projectModel);
    }

    @GetMapping("/getAllProjects")
    private ResponseEntity<List<ProjectModel>> getAllProjects(){
        List<Project> newProjectList = this.projectServiceImp.getAllProjects();
        List<ProjectModel> projectModelList=projectDTO.allEntitiesToModels(newProjectList);
        return ResponseEntity.ok().body(projectModelList);
    }

    @GetMapping("/getAllProjectSortedByDate")
    private  ResponseEntity<List<ProjectModel>> getAllProjectSortedByDate() {
        return projectServiceImp.getAllProjectSortedByDate();
    }
    @PostMapping("/updateProject/{parent_id}")
    private  ResponseEntity<ProjectModel> updateProject (@RequestBody ProjectModel projectModel ,@PathVariable("parent_id") int parentId){
        ResponseEntity<ProjectModel> project = this.projectServiceImp.updateProject(projectModel,parentId);
        return project;
    }
//    @GetMapping("/getProjectByCid/{c_id}")
//    private ResponseEntity<List<ProjectModel>> getProjectByCid(@PathVariable int c_id){
//        List<Project> newProject = this.projectServiceImp.getProjectByCid(c_id);
//        List<ProjectModel> projectModel=projectDTO.allEntitiesToModels(newProject);
//        return ResponseEntity.ok().body(projectModel);
//    }

    @GetMapping("/getProjectByOrgId/{o_id}")
    private ResponseEntity<List<Project>> getProjectByOrgId(@PathVariable("o_id") int o_id){
        ResponseEntity<List<Project>>  list = this.projectServiceImp.getProjectByOrgId(o_id);
        return list;
    }

    @PatchMapping("/updateProj/{p_id}")
    private ResponseEntity<?> updateProject(@PathVariable("p_id") int projectId,@RequestBody Map<Object,Object> fields){
        return projectServiceImp.updateProj(projectId,fields);
    }

}
