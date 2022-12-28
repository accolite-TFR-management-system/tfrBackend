package com.accolite.tfr.controller;

import com.accolite.tfr.dto.FeatureDto;
import com.accolite.tfr.dto.OrganisationDto;
import com.accolite.tfr.dto.ProjectDto;
import com.accolite.tfr.model.Feature;
import com.accolite.tfr.model.Organisation;
import com.accolite.tfr.model.Project;
import com.accolite.tfr.service.OrganisationServiceImp;
import com.accolite.tfr.service.ProjectServiceImp;
//import com.accolite.tfr.service.Service;
import org.springframework.beans.BeanUtils;
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

//    @Autowired
//    private Service service;
//    @PostMapping("/project")
//    private ResponseEntity<Project> addProject(@RequestBody Project project ){
//        return ResponseEntity.ok().body(this.service.addProject(project));
//    }
//    @GetMapping("/organisation/{org_id}")
//    private ResponseEntity<Organisation> organisation(@PathVariable int org_Id){
//        return ResponseEntity.ok().body(this.service.getOrganisation(org_Id));
//    }
//    @GetMapping("/feature/{feature_id}")
//    private ResponseEntity<Feature> organisation(@PathVariable int feature_id){
//        return ResponseEntity.ok().body(this.service.getFeature(feature_id));
//    }
//    @PostMapping("/feature")
//    private  ResponseEntity<FeatureDto> addFeature(@RequestBody Feature feature){
//        Feature newFeature = this.service.addFeature(feature);
//        FeatureDto featureDto = new FeatureDto();
//        BeanUtils.copyProperties(newFeature,featureDto);
//        return ResponseEntity.ok().body(featureDto);
    //}
    @PostMapping("/project")
    private  ResponseEntity<ProjectDto> addProject(@RequestBody ProjectDto projectDto){
//        Project newProject = this.service.addProject(project);
//        ProjectDto projectDto = new ProjectDto();
//        BeanUtils.copyProperties(newProject,projectDto);
        Project org = this.projectService.addProject(projectDto);
        ProjectDto pdto = this.projectService.mapToDto(org);
        return ResponseEntity.ok().body(pdto);
    }

    @PostMapping("/addDivision")
    private ResponseEntity<OrganisationDto> addDivision(@RequestBody OrganisationDto organisation){
//        Organisation newOrganisation = this.service.addOrganisation(organisation);
//        OrganisationDto organisationDto = new OrganisationDto(organisation);
        //BeanUtils.copyProperties(newOrganisation,organisationDto);
        //OrganisationDto od = service.mapToDto(organisation);
        //Organisation org = service.mapToEntity(organisation);
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
