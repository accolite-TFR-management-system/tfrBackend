package com.accolite.tfr;

import com.accolite.tfr.dto.FeatureDto;
import com.accolite.tfr.dto.OrganisationDto;
import com.accolite.tfr.dto.ProjectDto;
import com.accolite.tfr.dto.ResourceDto;
import com.accolite.tfr.model.*;
import com.accolite.tfr.service.Service;
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
    private Service service;
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
    @PostMapping("/feature")
    private  ResponseEntity<FeatureDto> addFeature(@RequestBody Feature feature){
        Feature newFeature = this.service.addFeature(feature);
        FeatureDto featureDto = new FeatureDto();
        BeanUtils.copyProperties(newFeature,featureDto);
        return ResponseEntity.ok().body(featureDto);
    }
    @PostMapping("/project")
    private  ResponseEntity<ProjectDto> addProject(@RequestBody Project project){
        Project newProject = this.service.addProject(project);
        ProjectDto projectDto = new ProjectDto();
        BeanUtils.copyProperties(newProject,projectDto);
        return ResponseEntity.ok().body(projectDto);
    }
//    @PostMapping("/addResource")
//    private ResponseEntity<ResourceDto> addResource(@RequestBody ResourceDto resourcedto){
//        Resource resource = new Resource();
//        BeanUtils.copyProperties(resourcedto,resource);
//        Resource newResource = this.service.addResource(resource);
//        ResourceDto resourceDto = new ResourceDto();
//        BeanUtils.copyProperties(newResource,resourceDto);
//        return ResponseEntity.ok().body(resourceDto);
//    }
    @PostMapping("/addDivision")
    private ResponseEntity<OrganisationDto> addDivision(@RequestBody Organisation organisation){
        Organisation newOrganisation = this.service.addOrganisation(organisation);
        OrganisationDto organisationDto = new OrganisationDto();
        BeanUtils.copyProperties(newOrganisation,organisationDto);
        return ResponseEntity.ok().body(organisationDto);
    }
    @PostMapping("/addProjectStatus")
    private  ResponseEntity<ProjectStatus> addProjectStatus(@RequestBody ProjectStatus projectStatus){
        ProjectStatus newProjectStatus = this.service.addProjectStatus(projectStatus);
        return ResponseEntity.ok().body(newProjectStatus);
    }
    @PostMapping("/addResourceFeature")
    private  ResponseEntity<ResourceFeatureMN> addResourceFeatureMN(@RequestBody ResourceFeatureMN resourceFeatureMN){
        ResourceFeatureMN newResourceFeatureMN = this.service.addResourceFeatureMN(resourceFeatureMN);
        return ResponseEntity.ok().body(newResourceFeatureMN);
    }
    @PostMapping("/addMilestone")
    private ResponseEntity<Milestone> addMilestone(@RequestBody Milestone milestone){
        Milestone newMilestone = this.service.addMilestone(milestone);
        return ResponseEntity.ok().body(newMilestone);
    }
    @PostMapping("/addClient")
    private ResponseEntity<Clients> addClient(@RequestBody Clients Client){
        Clients newClient = this.service.addClient(Client);
        return ResponseEntity.ok().body(newClient);
    }
    @PostMapping("/addAccoliteClientMN")
    private ResponseEntity<AccoliteClientMN> addAccoliteClientMN(@RequestBody AccoliteClientMN accoliteClientMN){
        AccoliteClientMN newAccoliteClientMN = this.service.addAccoliteClientMN(accoliteClientMN);
        return ResponseEntity.ok().body(newAccoliteClientMN);
    }
    @PostMapping("/addDesignation")
    private ResponseEntity<Designation> addAccoliteClientMN(@RequestBody Designation designation){
        Designation newDesignation = this.service.addDesignation(designation);
        return ResponseEntity.ok().body(newDesignation);
    }
    @PostMapping("/addResourceHistory")
    private ResponseEntity<ResourceHistory> addResourceHistory(@RequestBody ResourceHistory resourceHistory){
        ResourceHistory newResourceHistory = this.service.addResourceHistory(resourceHistory);
        return ResponseEntity.ok().body(newResourceHistory);
    }
    @PostMapping("/addRisk")
    private ResponseEntity<Risk> addRisk(@RequestBody Risk risk){
        Risk newRisk= this.service.addRisk(risk);
        return ResponseEntity.ok().body(newRisk);
    }
    @PostMapping("/addGoal")
    private ResponseEntity<Goals> addGoal(@RequestBody Goals goals){
        Goals newGoal= this.service.addGoal(goals);
        return ResponseEntity.ok().body(newGoal);
    }
    @PostMapping("/addResource")
    private ResponseEntity<Resource> addResource(@RequestBody Resource resource){
        Resource newResource= this.service.addResource(resource);
        return ResponseEntity.ok().body(newResource);
    }

}
