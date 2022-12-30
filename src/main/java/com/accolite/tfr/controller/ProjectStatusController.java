package com.accolite.tfr.controller;


import com.accolite.tfr.DTO.ProjectStatusDTO;
import com.accolite.tfr.entity.ProjectStatus;
import com.accolite.tfr.DTOmodel.ProjectStatusModel;
import com.accolite.tfr.repository.ProjectStatusRepository;
import com.accolite.tfr.service.ProjectStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tfr")
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
}
