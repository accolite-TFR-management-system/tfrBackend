//package com.accolite.tfr;
//
////import com.accolite.tfr.dto.*;
//import com.accolite.tfr.model.*;
//import com.accolite.tfr.service.DesignationService;
//import com.accolite.tfr.service.Service;
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Set;
//
//@RestController
//@RequestMapping("/tfr")
//public class TestController {
//
//    @GetMapping("/testController")
//    public String testCtrl() {
//        return "Working Successfully";
//    }
//
//    @Autowired
//    private DesignationService designationService;
//    @Autowired
//    private Service service;
////    @PostMapping("/feature")
////    private  ResponseEntity<FeatureDto> addFeature(@RequestBody Feature feature){
////        Feature newFeature = this.service.addFeature(feature);
////        FeatureDto featureDto = new FeatureDto();
////        BeanUtils.copyProperties(newFeature,featureDto);
////        return ResponseEntity.ok().body(featureDto);
////    }
////    @PostMapping("/project")
////    private  ResponseEntity<ProjectDto> addProject(@RequestBody Project project){
////        Project newProject = this.service.addProject(project);
////        ProjectDto projectDto = new ProjectDto();
////        BeanUtils.copyProperties(newProject,projectDto);
////        return ResponseEntity.ok().body(projectDto);
////    }
////    @PostMapping("/addDivision")
////    private ResponseEntity<OrganisationDto> addDivision(@RequestBody Organisation organisation){
////        Organisation newOrganisation = this.service.addOrganisation(organisation);
////        OrganisationDto organisationDto = new OrganisationDto();
////        BeanUtils.copyProperties(newOrganisation,organisationDto);
////        return ResponseEntity.ok().body(organisationDto);
////    }
////    @PostMapping("/addProjectStatus")
////    private  ResponseEntity<ProjectStatus> addProjectStatus(@RequestBody ProjectStatus projectStatus){
////        ProjectStatus newProjectStatus = this.service.addProjectStatus(projectStatus);
////        return ResponseEntity.ok().body(newProjectStatus);
////    }
////    @PostMapping("/addResourceFeature")
////    private  ResponseEntity<ResourceFeatureMN> addResourceFeatureMN(@RequestBody ResourceFeatureMN resourceFeatureMN){
////        ResourceFeatureMN newResourceFeatureMN = this.service.addResourceFeatureMN(resourceFeatureMN);
////        return ResponseEntity.ok().body(newResourceFeatureMN);
////    }
////    @PostMapping("/addMilestone")
////    private ResponseEntity<Milestone> addMilestone(@RequestBody Milestone milestone){
////        Milestone newMilestone = this.service.addMilestone(milestone);
////        return ResponseEntity.ok().body(newMilestone);
////    }
////    @PostMapping("/addClient")
////    private ResponseEntity<Clients> addClient(@RequestBody Clients Client){
////        Clients newClient = this.service.addClient(Client);
////        return ResponseEntity.ok().body(newClient);
////    }
////    @PostMapping("/addAccoliteClientMN")
////    private ResponseEntity<AccoliteClientMN> addAccoliteClientMN(@RequestBody AccoliteClientMN accoliteClientMN){
////        AccoliteClientMN newAccoliteClientMN = this.service.addAccoliteClientMN(accoliteClientMN);
////        return ResponseEntity.ok().body(newAccoliteClientMN);
////    }
//////    @PostMapping("/addDesignation")
//////    private ResponseEntity<Designation> addAccoliteClientMN(@RequestBody Designation designation){
//////        Designation newDesignation = this.service.addDesignation(designation);
//////        return ResponseEntity.ok().body(newDesignation);
//////    }
////    @PostMapping("/addResourceHistory")
////    private ResponseEntity<ResourceHistory> addResourceHistory(@RequestBody ResourceHistory resourceHistory){
////        ResourceHistory newResourceHistory = this.service.addResourceHistory(resourceHistory);
////        return ResponseEntity.ok().body(newResourceHistory);
////    }
////    @PostMapping("/addRisk")
////    private ResponseEntity<Risk> addRisk(@RequestBody Risk risk){
////        Risk newRisk= this.service.addRisk(risk);
////        return ResponseEntity.ok().body(newRisk);
////    }
////    @PostMapping("/addGoal")
////    private ResponseEntity<Goals> addGoal(@RequestBody Goals goals){
////        Goals newGoal= this.service.addGoal(goals);
////        return ResponseEntity.ok().body(newGoal);
////    }
////    @PostMapping("/addResource")
////    private ResponseEntity<Resource> addResource(@RequestBody Resource resource){
////        Resource newResource= this.service.addResource(resource);
////        return ResponseEntity.ok().body(newResource);
////    }
//////    @GetMapping("/getResource/{r_id}")
//////    private ResponseEntity<Resource> getResource(@PathVariable int r_id){
//////        Resource newResource= this.service.getResource(r_id);
//////        return ResponseEntity.ok().body(newResource);
//////    }
////    @PostMapping("/addDesignation")
////    private ResponseEntity<DesignationDto> addAccoliteClientMN(@RequestBody DesignationDto dto){
////        //Designation designation = this.designationService.mapToEntity(dto);
////        Designation newDesignation = this.designationService.addDesignation(dto);
////        DesignationDto ddto = this.designationService.mapToDto(newDesignation);
////        return ResponseEntity.ok().body(ddto);
////    }
////    @GetMapping("/getProject/{p_id}")
////    private ResponseEntity<Project> getProject(@PathVariable int p_id){
////        Project newProject = this.service.getProject(p_id);
////        return ResponseEntity.ok().body(newProject);
////    }
////    @GetMapping("/getClient/{c_id}")
////    private ResponseEntity<Clients> getClient(@PathVariable int c_id){
////        Clients newClient = this.service.getClient(c_id);
////        return  ResponseEntity.ok().body(newClient);
////    }
////    @GetMapping("/getMilestone/{p_id}")
////    private ResponseEntity<List<Milestone>> getMilestone(@PathVariable int p_id){
////        List<Milestone> newMilestone = this.service.getMilestone(p_id);
////        return  ResponseEntity.ok().body(newMilestone);
////    }
////    @GetMapping("/getGoal/{g_id}")
////    private ResponseEntity<Goals> getGoal(@PathVariable int g_id){
////        Goals newGoal = this.service.getGoal(g_id);
////        return  ResponseEntity.ok().body(newGoal);
////    }
////    @GetMapping("/Resource/{d_id}")
////    private ResponseEntity<List<Resource>> getResources(@PathVariable int d_id){
////        List<Resource> newResources = this.service.getResources(d_id);
////        return  ResponseEntity.ok().body(newResources);
////    }
////    @GetMapping("/Goals/{m_id}")
////    private ResponseEntity<List<Goals>> getGoals(@PathVariable int m_id){
////        List<Goals> newGoals= this.service.getGoals(m_id);
////        return  ResponseEntity.ok().body(newGoals);
////    }
////    @GetMapping("/ResourceFeatureList/{r_id}")
////    private ResponseEntity<List<ResourceFeatureMN>> getResourceFeatureList(@PathVariable int r_id){
////        List<ResourceFeatureMN> newResourceFeatureMN= this.service.getResourceFeatureMN(r_id);
////        return  ResponseEntity.ok().body(newResourceFeatureMN);
////    }
////    @PostMapping("/ResourceProjectMN")
////    private  ResponseEntity<ResourceProjectMN> addResourceProjectMN(@RequestBody ResourceProjectMN resourceProjectMN){
////        ResourceProjectMN newResourceProjectMN = this.service.addResourceProjectMN(resourceProjectMN);
////        return  ResponseEntity.ok().body(newResourceProjectMN);
////    }
////    @GetMapping("/getProjectStatus/{p_id}")
////    private  ResponseEntity<List<ProjectStatus>> getProjectStatus(@PathVariable int p_id){
////        List<ProjectStatus> newProjectStatus = this.service.getProjectStatus(p_id);
////        return  ResponseEntity.ok().body(newProjectStatus);
////    }
////    @GetMapping("/getRisk/{p_id}")
////    private ResponseEntity<List<Risk>> getRisk(@PathVariable int p_id) {
////        List<Risk> newRisk = this.service.getRisk(p_id);
////        return ResponseEntity.ok().body(newRisk);
////    }
////    @GetMapping("/getResourceHistoryByRID/{r_id}")
////    private  ResponseEntity<List<ResourceHistory>> getResourceHistoryByResource(@PathVariable int r_id){
////        List<ResourceHistory> newList = this.service.getResourceHistoryByResourceId(r_id);
////        return ResponseEntity.ok().body(newList);
////    }
////    @GetMapping("/getResourceHistoryByPID/{p_id}")
////    private  ResponseEntity<List<ResourceHistory>> getResourceHistoryByProject(@PathVariable int p_id){
////        List<ResourceHistory> newList = this.service.getResourceHistoryByProjectId(p_id);
////        return ResponseEntity.ok().body(newList);
////    }
////    @PostMapping("/add/resource/{resourceId}/project/{projectId}")
////    private ResponseEntity<Project>  addResourceToProject(@PathVariable("resourceId") int employeeId, @PathVariable("projectId") int projectId)
////    {
////        return service.addEmployeeToProject(employeeId, projectId);
////    }
////    @PostMapping("/add/resource/{resourceId}/feature/{featureId}")
////    private ResponseEntity<Feature>  addResourceToFeature(@PathVariable("resourceId") int resourceId, @PathVariable("featureId") int featureId)
////    {
////        return service.addEmployeeToFeature(resourceId, featureId);
////    }
////    @PostMapping("/add/resource/{resourceId}/client/{clientId}")
////    private ResponseEntity<Clients>  addResourceToClient(@PathVariable("resourceId") int resourceId, @PathVariable("clientId") int clientId)
////    {
////        return service.addEmployeeToClient(resourceId, clientId);
////    }
////    @GetMapping("/get/resource/{resourceId}/project")
////    private ResponseEntity<Set<Resource>> getResourcesOnProject(@PathVariable("projectId") int ProjectId){
////        return service.getResourcesOnProject(ProjectId);
////    }
//}
