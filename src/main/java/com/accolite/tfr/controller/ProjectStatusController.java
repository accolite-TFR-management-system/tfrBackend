package com.accolite.tfr.controller;


import com.accolite.tfr.DTO.ProjectStatusDTO;
import com.accolite.tfr.model.ProjectStatus;
import com.accolite.tfr.DTOmodel.ProjectStatusModel;
import com.accolite.tfr.repository.ProjectStatusRepository;
import com.accolite.tfr.service.ProjectStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tfr")
@CrossOrigin(origins="http://localhost:4200")
public class ProjectStatusController {

    @Autowired
    private ProjectStatusRepository projectStatusRepository;
    @Autowired
    public ProjectStatusService projectStatusService;
    @Autowired(required = false)
    public ProjectStatusDTO projectStatusDTO;

    @PostMapping("/addProjectStatus")
    private ResponseEntity<ProjectStatusModel> addDesignation(@RequestBody ProjectStatusModel projectStatusModel) {
        ProjectStatus projectStatus = this.projectStatusService.addProjectStatus(projectStatusModel);
        ProjectStatusModel projectStatusModel1=projectStatusDTO.entityToModel(projectStatus);
        return ResponseEntity.ok().body(projectStatusModel1);
    }

    @GetMapping("/getProjectStatus/{p_id}")
    private  ResponseEntity<List<ProjectStatusModel>> getProjectStatus(@PathVariable int p_id){
        List<ProjectStatus> newProjectStatus = this.projectStatusService.getProjectStatus(p_id);
        List<ProjectStatusModel> projectStatusModel=this.projectStatusDTO.allEntitiesToModels(newProjectStatus);
        return  ResponseEntity.ok().body(projectStatusModel);
    }
}
