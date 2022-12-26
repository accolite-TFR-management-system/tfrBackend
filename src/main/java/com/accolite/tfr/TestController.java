package com.accolite.tfr;

import com.accolite.tfr.dto.FeatureDto;
import com.accolite.tfr.dto.ProjectDto;
import com.accolite.tfr.model.Feature;
import com.accolite.tfr.model.Organisation;
import com.accolite.tfr.model.Project;
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
}
