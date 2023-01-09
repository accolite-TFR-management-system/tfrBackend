package com.accolite.tfr.controller;


import com.accolite.tfr.DTO.ResourceDTO;
import com.accolite.tfr.DTOmodel.ClientsModel;
import com.accolite.tfr.DTOmodel.FeatureModel;
import com.accolite.tfr.DTOmodel.ProjectModel;
import com.accolite.tfr.model.Clients;
import com.accolite.tfr.model.Feature;
import com.accolite.tfr.model.Project;
import com.accolite.tfr.model.Resource;
import com.accolite.tfr.DTOmodel.ResourceModel;
import com.accolite.tfr.repository.ResourceRepository;
import com.accolite.tfr.service.ResourceServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/tfr")
public class ResourceController {

    @Autowired
    private ResourceRepository resourceRepository;
    @Autowired
    public ResourceServiceImp resourceServiceImp;
    @Autowired(required = false)
    public ResourceDTO resourceDTO;

    @PostMapping("/addResource")
    private ResponseEntity<ResourceModel> addResource(@RequestBody ResourceModel resourceModel) {
    	System.out.println(resourceModel);
        Resource resource = this.resourceServiceImp.addResource(resourceModel);
        ResourceModel resourceModel1 = this.resourceDTO.entityToModel(resource);
        return ResponseEntity.ok().body(resourceModel1);
    }

    @GetMapping("/ResourceByDesignation/{d_id}")
    private ResponseEntity<List<ResourceModel>> getResources(@PathVariable int d_id){
        List<Resource> newResources = this.resourceServiceImp.getResources(d_id);
        List<ResourceModel> resourceModels=this.resourceDTO.allEntitiesToModels(newResources);
        return  ResponseEntity.ok().body(resourceModels);
    }

    @GetMapping("/Resource/{r_id}")
    private ResponseEntity<ResourceModel> getResourcesById(@PathVariable int r_id){
        Resource newResource=this.resourceServiceImp.getResource(r_id);
        ResourceModel resourceModel=this.resourceDTO.entityToModel(newResource);
        return ResponseEntity.ok().body(resourceModel);
    }

    @PostMapping("/add/resource/{resourceId}/project/{projectId}")
    private ResponseEntity<ProjectModel>  addResourceToProject(@PathVariable("resourceId") int employeeId, @PathVariable("projectId") int projectId)
    {
        return this.resourceServiceImp.addEmployeeToProject(employeeId, projectId);
    }
    @PostMapping("/add/resource/{resourceId}/feature/{featureId}")
    private ResponseEntity<FeatureModel>  addResourceToFeature(@PathVariable("resourceId") int resourceId, @PathVariable("featureId") int featureId)
    {
        return resourceServiceImp.addEmployeeToFeature(resourceId, featureId);
    }
    @PostMapping("/add/resource/{resourceId}/client/{clientId}")
    private ResponseEntity<ClientsModel>  addResourceToClient(@PathVariable("resourceId") int resourceId, @PathVariable("clientId") int clientId)
    {
        return resourceServiceImp.addEmployeeToClient(resourceId, clientId);
    }

//    @GetMapping("/get/resource/{projectId}/project")
//    private ResponseEntity<Set<ResourceModel>> getResourcesOnProject(@PathVariable("projectId") int ProjectId){
//        return resourceServiceImp.getResourcesOnProject(ProjectId);
//    }

    @PatchMapping("/updateResource/{r_id}")
    private ResponseEntity<?> updateResource(@PathVariable("r_id") int resourceId,@RequestBody Map<Object,Object> fields){
        return resourceServiceImp.updateResource(resourceId,fields);
    }

    @PostMapping("/validate")
    private ResponseEntity<List<Object>> validateuser(@RequestBody ResourceModel user){
        return ResponseEntity.ok().body(this.resourceServiceImp.validateuser(user));
    }

    @GetMapping("/get/resource/{projectId}/project")
    private ResponseEntity<Set<ResourceModel>> getResourcesOnProject(@PathVariable("projectId") int ProjectId){
        return resourceServiceImp.getResourcesOnProject(ProjectId);
    }
    @GetMapping("/get/resource/{resourceId}/feature")
    private ResponseEntity<Set<FeatureModel>> getfeaturesForResources(@PathVariable("resourceId") int resourceId){
        return resourceServiceImp.getfeaturesForResources(resourceId);
    }
    @GetMapping("/get/resource/{resourceId}/client")
    private ResponseEntity<Set<ClientsModel>> getClientsForResources(@PathVariable("resourceId") int resourceId){
        return resourceServiceImp.getClientsForResources(resourceId);
    }
       
    @GetMapping("/showAddResource/{id}")
    private Boolean showAddResource(@PathVariable("id") int id){
        Boolean result = this.resourceServiceImp.showAddResource(id);
        if(result!=null){
            return result;
        }
        else{
            return null;
        }
    }
    
    @GetMapping("/getallresource")
    private ResponseEntity<HashMap<String,Integer>> getallresource(){
        return ResponseEntity.ok().body(this.resourceServiceImp.getallresources());
    }
}
