package com.accolite.tfr.controller;

import com.accolite.tfr.dto.OrganisationDto;
import com.accolite.tfr.dto.ProjectDto;
import com.accolite.tfr.model.Organisation;
import com.accolite.tfr.model.Project;
import com.accolite.tfr.service.OrganisationServiceImp;
import com.accolite.tfr.service.ProjectServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tfr")
public class TestController {

    @GetMapping("/testController")
    public String testCtrl()
    {
        return "Working Successfully";
    }

    @Autowired
    private ProjectServiceImp projectService;
    @Autowired
    private OrganisationServiceImp organisationService;

    @PostMapping("/project")
    private  ResponseEntity<ProjectDto> addProject(@RequestBody ProjectDto projectDto){
        Project org = this.projectService.addProject(projectDto);
        ProjectDto pdto = this.projectService.mapToDto(org);
        return ResponseEntity.ok().body(pdto);
    }

    @PostMapping("/addDivision")
    private ResponseEntity<OrganisationDto> addDivision(@RequestBody OrganisationDto organisation){
        Organisation org = this.organisationService.addOrganisation(organisation);
        OrganisationDto od = this.organisationService.mapToDto(org);
        return ResponseEntity.ok().body(od);
    }

    @GetMapping("/organisation/{org_id}")
    private ResponseEntity<Organisation> organisation(@PathVariable int org_Id){
        Organisation org = this.organisationService.getOrganisation(org_Id);
//        OrganisationDto od = this.organisationService.mapToDto(org);
        return ResponseEntity.ok().body(org);
    }



}
