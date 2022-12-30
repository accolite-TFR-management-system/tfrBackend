package com.accolite.tfr;

import com.accolite.tfr.DTO.ResourceDTO;
import com.accolite.tfr.DTOmodel.*;
import com.accolite.tfr.entity.*;
import com.accolite.tfr.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
    private AccoliteClientMNServiceImp accoliteClientMNServiceImp;
    @Autowired
    private ClientServiceImp clientServiceImp;
    @Autowired
    private FeatureServiceImp featureServiceImp;
    @Autowired
    private GoalsServiceImp goalsServiceImp;
    @Autowired
    private MilestoneServiceImp milestoneServiceImp;
    @Autowired
    private OrganisationServiceImp organisationServiceImp;
    @Autowired
    private ProjectServiceImp projectServiceImp;
    @Autowired
    private ProjectStatusServiceImp projectStatusServiceImp;
    @Autowired
    private ResourceHistoryServiceImp resourceHistoryServiceImp;
    @Autowired
    private ResourceServiceImp resourceServiceImp;
    @Autowired
    private RiskServiceImp riskServiceImp;
    @Autowired
    private DesignationServiceImp designationServiceImp;
    @Autowired(required = false)
//    @Autowired
    private ResourceDTO resourceDTO;
//    @PostMapping("/feature")
//    private  ResponseEntity<FeatureModel> addFeature(@RequestBody Feature feature){
//        Feature newFeature = this.service.addFeature(feature);
////        FeatureDto featureDto = new FeatureDto();
////        BeanUtils.copyProperties(newFeature,featureDto);
//        FeatureModel fdto = featureServiceImp.mapToDto(newFeature);
//        return ResponseEntity.ok().body(fdto);
//    }
//    @PostMapping("/project")
//    private  ResponseEntity<ProjectModel> addProject(@RequestBody Project project){
//        Project newProject = this.service.addProject(project);
////        ProjectDto projectDto = new ProjectDto();
////        BeanUtils.copyProperties(newProject,projectDto);
//        ProjectModel pdto = projectServiceImp.mapToDto(newProject);
//        return ResponseEntity.ok().body(pdto);
//    }
//    @PostMapping("/addResource")
//    private ResponseEntity<ResourceDto> addResource(@RequestBody ResourceDto resourcedto){
//        Resource resource = new Resource();
//        BeanUtils.copyProperties(resourcedto,resource);
//        Resource newResource = this.service.addResource(resource);
//        ResourceDto resourceDto = new ResourceDto();
//        BeanUtils.copyProperties(newResource,resourceDto);
//        return ResponseEntity.ok().body(resourceDto);
//    }
//    @PostMapping("/addDivision")
//    private ResponseEntity<OrganisationModel> addDivision(@RequestBody Organisation organisation){
//        Organisation newOrganisation = this.service.addOrganisation(organisation);
//        OrganisationModel odto = organisationServiceImp.mapToDto(newOrganisation);
////        OrganisationDto organisationDto = new OrganisationDto();
////        BeanUtils.copyProperties(newOrganisation,organisationDto);
//        return ResponseEntity.ok().body(odto);
//    }
//    @PostMapping("/addProjectStatus")
//    private  ResponseEntity<ProjectStatusModel> addProjectStatus(@RequestBody ProjectStatus projectStatus){
//        ProjectStatus newProjectStatus = this.service.addProjectStatus(projectStatus);
//        ProjectStatusModel psdto = projectStatusServiceImp.mapToDto(newProjectStatus);
//        return ResponseEntity.ok().body(psdto);
//    }
    @PostMapping("/addResourceFeature")
    private  ResponseEntity<ResourceFeatureMN> addResourceFeatureMN(@RequestBody ResourceFeatureMN resourceFeatureMN){
        ResourceFeatureMN newResourceFeatureMN = this.service.addResourceFeatureMN(resourceFeatureMN);
        return ResponseEntity.ok().body(newResourceFeatureMN);
    }
//    @PostMapping("/addMilestone")
//    private ResponseEntity<MilestoneModel> addMilestone(@RequestBody Milestone milestone){
//        Milestone newMilestone = this.service.addMilestone(milestone);
//        MilestoneModel mdto = milestoneServiceImp.mapToDto(newMilestone);
//        return ResponseEntity.ok().body(mdto);
//    }
//    @PostMapping("/addClient")
//    private ResponseEntity<ClientsModel> addClient(@RequestBody Clients Client){
//        Clients newClient = this.service.addClient(Client);
//        ClientsModel cdto = clientServiceImp.mapToDto(newClient);
//        return ResponseEntity.ok().body(cdto);
//    }
    @PostMapping("/addAccoliteClientMN")
    private ResponseEntity<AccoliteClientMN> addAccoliteClientMN(@RequestBody AccoliteClientMN accoliteClientMN){
        AccoliteClientMN newAccoliteClientMN = this.service.addAccoliteClientMN(accoliteClientMN);
        AccoliteClientMNModel acdto = accoliteClientMNServiceImp.mapToDto(newAccoliteClientMN);
        return ResponseEntity.ok().body(newAccoliteClientMN);
    }
//    @PostMapping("/addDesignation")
//    private ResponseEntity<DesignationModel> addAccoliteClientMN(@RequestBody Designation designation){
//        Designation newDesignation = this.service.addDesignation(designation);
//        DesignationModel ddto = this.designationServiceImp.mapToDto(newDesignation);
//        return ResponseEntity.ok().body(ddto);
//    }
//    @PostMapping("/addResourceHistory")
//    private ResponseEntity<ResourceHistoryModel> addResourceHistory(@RequestBody ResourceHistory resourceHistory){
//        ResourceHistory newResourceHistory = this.service.addResourceHistory(resourceHistory);
//        ResourceHistoryModel rhdto = resourceHistoryServiceImp.mapToDto(newResourceHistory);
//        return ResponseEntity.ok().body(rhdto);
//    }
//    @PostMapping("/addRisk")
//    private ResponseEntity<RiskModel> addRisk(@RequestBody Risk risk){
//        Risk newRisk= this.service.addRisk(risk);
//        RiskModel rdto = riskServiceImp.mapToDto(newRisk);
//        return ResponseEntity.ok().body(rdto);
//    }
//    @PostMapping("/addGoal")
//    private ResponseEntity<GoalsModel> addGoal(@RequestBody Goals goals){
//        Goals newGoal= this.service.addGoal(goals);
//        GoalsModel gdto = goalsServiceImp.mapToDto(newGoal);
//        return ResponseEntity.ok().body(gdto);
//    }
//    @PostMapping("/addResource")
//    private ResponseEntity<ResourceModel> addResource(@RequestBody Resource resource){
//        Resource newResource= this.service.addResource(resource);
//        ResourceModel rdto = resourceServiceImp.mapToDto(newResource);
//        return ResponseEntity.ok().body(rdto);
//    }
//    @PostMapping("/addResource")
//    private ResponseEntity<ResourceModel> addResource(@RequestBody ResourceModel resourceModel) {
//        Resource resource = this.resourceServiceImp.addResource(resourceModel);
//        ResourceModel resourceModel1 = this.resourceDTO.entityToModel(resource);
//        return ResponseEntity.ok().body(resourceModel1);
//    }
    @GetMapping("/getResource/{desg_id}")
    private ResponseEntity<List<Resource>> getResource(@PathVariable int desg_id) {
        return ResponseEntity.ok().body(this.resourceServiceImp.findResourceByDesignationId(desg_id));
    }
    @PostMapping("/addResourceProjectMN")
    private ResponseEntity<ResourceProjectMN> addResourceProjectMN(@RequestBody ResourceProjectMN resourceProjectMN) {
        return ResponseEntity.ok().body(this.service.addResourceProjectMN(resourceProjectMN));
    }

}
