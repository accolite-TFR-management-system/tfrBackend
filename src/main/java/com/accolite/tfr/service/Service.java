package com.accolite.tfr.service;

import com.accolite.tfr.exception.Exception;
import com.accolite.tfr.model.*;
import com.accolite.tfr.repository.*;
import com.mysql.cj.xdevapi.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.*;

//import org.springframework.stereotype.Service
@org.springframework.stereotype.Service
public class Service {
    @Autowired
    private  ResourceProjectMNRepository resourceProjectMNRepository;
    @Autowired
    private  GoalRepository goalRepository;
    @Autowired
    private RiskRepository riskRepository;
    @Autowired
    private DesignationRepository designationRepository;
    @Autowired
    private AccoliteClientMNRepository accoliteClientMNRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private MilestoneRepository milestoneRepository;
    @Autowired
    private ResourceFeatureMNRepository resourceFeatureMNRepository;
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private ProjectStatusRepository projectStatusRepository;
    @Autowired
    private FeatureRepository featureRepository;
    @Autowired
    private OrganisationRepository organisationRepository;
    @Autowired
    private ResourceRepository resourceRepository;
    @Autowired
    private ResourceHistoryRepository resourceHistoryRepository;

    public Project addProject(Project project) {
        return this.projectRepository.save(project);
    }

    public Organisation getOrganisation(int org_id) {
        Optional<Organisation> org=this.organisationRepository.findById(org_id);
        if(org.isPresent()) {
            return org.get();
        }
        else{
            throw new Exception("User didn't found with ID: " + org_id);
        }
    }

    public Feature addFeature(Feature feature) {
        return this.featureRepository.save(feature);
    }

    public Resource addResource(Resource resource) {
        return this.resourceRepository.save(resource);
    }

    public Organisation addOrganisation(Organisation organisation) {
        return this.organisationRepository.save(organisation);
    }

    public ProjectStatus addProjectStatus(ProjectStatus projectStatus) {
        return this.projectStatusRepository.save(projectStatus);
    }

    public ResourceFeatureMN addResourceFeatureMN(ResourceFeatureMN resourceFeatureMN) {
        return this.resourceFeatureMNRepository.save(resourceFeatureMN);
    }

    public Milestone addMilestone(Milestone milestone) {
        return this.milestoneRepository.save(milestone);
    }

    public Clients addClient(Clients client) {
        return this.clientRepository.save(client);
    }

    public AccoliteClientMN addAccoliteClientMN(AccoliteClientMN accoliteClientMN) {
        return this.accoliteClientMNRepository.save(accoliteClientMN);
    }

    public Designation addDesignation(Designation designation) {
        return this.designationRepository.save(designation);
    }

    public ResourceHistory addResourceHistory(ResourceHistory resourceHistory) {
        return this.resourceHistoryRepository.save(resourceHistory);
    }

    public Risk addRisk(Risk risk) {
        return this.riskRepository.save(risk);
    }

    public Goals addGoal(Goals goals) {
        return this.goalRepository.save(goals);
    }

    public Resource getResource(int r_id) {
        Optional<Resource> newResource = this.resourceRepository.findById(r_id);
        if(newResource.isPresent()){
            return newResource.get();
        }
        else{
            throw new Exception("Resource not found");
        }
    }

    public Project getProject(int p_id) {
        Optional<Project> project = Optional.ofNullable(this.projectRepository.findProjectById(p_id));
        if(project.isPresent()) {
            return project.get();
        }
        else {
            throw new Exception("Project not found");
        }
    }

//    public Clients getClient(int c_id) {
//        Optional<Clients> client = this.clientRepository.findById(c_id);
//        if(client.isPresent()){
//            return client.get();
//        }
//        else {
//            throw new Exception("Client not found");
//        }
//    }

//    public List<Milestone> getMilestone(int p_id) {
//        Optional<Project> project = Optional.ofNullable(this.projectRepository.findProjectById(p_id));
//        if(project.isPresent()) {
//            Optional<List<Milestone>> milestone = Optional.ofNullable(this.milestoneRepository.findMilestoneByPId(p_id));
//            if (milestone.isPresent()) {
//                return milestone.get();
//            } else {
//                throw new Exception("Milestone not found with project id : " + p_id);
//            }
//        }
//        else {
//            throw new Exception("Project not found with id : " + p_id);
//        }
//    }

//    public Goals getGoal(int g_id) {
//        Optional<Goals> goal = this.goalRepository.findById(g_id);
//        if(goal.isPresent()) {
//            return goal.get();
//        }
//        else {
//            throw new Exception("goal not found");
//        }
//    }

//    public List<Resource> getResources(int d_id) {
//        Optional<Designation> newDesignation =this.designationRepository.findById(d_id);
//        if(newDesignation.isPresent()) {
//            Optional<List<Resource>> newList = Optional.ofNullable(this.resourceRepository.findResourceByDesignationId(d_id));
//            if (newList.isPresent()) {
//                return newList.get();
//            } else {
//                throw new Exception("Resources not found");
//            }
//        }
//        else {
//            throw new Exception("Designation not found");
//        }
//    }

//    public List<Goals> getGoals(int m_id) {
//        Optional<Milestone> newMilestone =this.milestoneRepository.findById(m_id);
//        if(newMilestone.isPresent()) {
//            Optional<List<Goals>> newList = Optional.ofNullable(this.goalRepository.findResourceByMilestoneId(m_id));
//            if (newList.isPresent()) {
//                return newList.get();
//            } else {
//                throw new Exception("goals not found");
//            }
//        }
//        else {
//            throw new Exception("Milestone not found");
//        }
//    }

    public List<ResourceFeatureMN> getResourceFeatureMN(int r_id) {
        Optional<Resource> newResource =this.resourceRepository.findById(r_id);
        if(newResource.isPresent()) {
            Optional<List<ResourceFeatureMN>> newList = Optional.ofNullable(this.resourceFeatureMNRepository.findResourceByResourceId(r_id));
            if (newList.isPresent()) {
                return newList.get();
            } else {
                throw new Exception("Resource Feature list is empty");
            }
        }
        else {
            throw new Exception("Resource not found");
        }
    }

    public ResourceProjectMN addResourceProjectMN(ResourceProjectMN resourceProjectMN) {
        return  this.resourceProjectMNRepository.save(resourceProjectMN);
    }

//    public List<ProjectStatus> getProjectStatus(int p_id) {
//        Optional<Project> newProject = Optional.ofNullable(this.projectRepository.findProjectById(p_id));
//        if(newProject.isPresent()) {
//            Optional<List<ProjectStatus>> newList = Optional.ofNullable(this.projectStatusRepository.findProjectStatusByProjectId(p_id));
//            if (newList.isPresent()) {
//                return newList.get();
//            } else {
//                throw new Exception("project status not found");
//            }
//        }
//        else {
//            throw new Exception("project not found");
//        }
//    }

//    public List<Risk> getRisk(int p_id) {
//        Optional<Project> newProject = Optional.ofNullable(this.projectRepository.findProjectById(p_id));
//        if(newProject.isPresent()) {
//            Optional<List<Risk>> newList = Optional.ofNullable(this.riskRepository.findRiskByProjectId(p_id));
//            if (newList.isPresent()) {
//                return newList.get();
//            } else {
//                throw new Exception("Risk  not found");
//            }
//        }
//        else {
//            throw new Exception("project not found");
//        }
//    }

//    public List<ResourceHistory> getResourceHistoryByResourceId(int r_id) {
//        Optional<Resource> newResource = Optional.ofNullable(this.resourceRepository.findResourceById(r_id));
//        if(newResource.isPresent()) {
//            Optional<List<ResourceHistory>> newList = Optional.ofNullable(this.resourceHistoryRepository.findResourceHistoryByResourceId(r_id));
//            if (newList.isPresent()) {
//                return newList.get();
//            } else {
//                throw new Exception("Resource HIstory  not found");
//            }
//        }
//        else {
//            throw new Exception("Resource not found");
//        }
//    }
//    public List<ResourceHistory> getResourceHistoryByProjectId(int p_id) {
//        Optional<Project> newProject = Optional.ofNullable(this.projectRepository.findProjectById(p_id));
//        if(newProject.isPresent()) {
//            Optional<List<ResourceHistory>> newList = Optional.ofNullable(this.resourceHistoryRepository.findResourceHistoryByProjectId(p_id));
//            if (newList.isPresent()) {
//                return newList.get();
//            } else {
//                throw new Exception("Resource History  not found");
//            }
//        }
//        else {
//            throw new Exception("Project not found");
//        }
//    }

//    public ResponseEntity<Project> addEmployeeToProject(int employeeId, int projectId) {
//        Optional<Resource> employeeOptional= Optional.ofNullable(this.resourceRepository.findResourceById(employeeId));
//        Optional<Project> projectOptional= Optional.ofNullable(this.projectRepository.findProjectById(projectId));
//        if(projectOptional.isPresent() && employeeOptional.isPresent())
//        {
//            Resource employee=employeeOptional.get();
//            Project project=projectOptional.get();
//            Set<Resource> s=project.getResource();
//            project.getResource().add(employee);
//            projectRepository.save(project);
//            return new ResponseEntity<Project>(project, HttpStatus.CREATED);
//        }
//        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
//    }
//
//    public ResponseEntity<Feature> addEmployeeToFeature(int resourceId, int featureId) {
//        Optional<Resource> employeeOptional= Optional.ofNullable(this.resourceRepository.findResourceById(resourceId));
//        Optional<Feature> FeatureOptional= Optional.ofNullable(this.featureRepository.findFeatureById(featureId));
//        if(FeatureOptional.isPresent() && employeeOptional.isPresent())
//        {
//            Resource employee=employeeOptional.get();
//            Feature feature=FeatureOptional.get();
//            Set<Resource> s=feature.getResourcef();
//            feature.getResourcef().add(employee);
//            featureRepository.save(feature);
//            return new ResponseEntity<Feature>(feature, HttpStatus.CREATED);
//        }
//        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
//
//    }
//
//    public ResponseEntity<Clients> addEmployeeToClient(int resourceId, int clientId) {
//        Optional<Resource> employeeOptional= Optional.ofNullable(this.resourceRepository.findResourceById(resourceId));
//        Optional<Clients> clientOptional= Optional.ofNullable(this.clientRepository.findClientsById(clientId));
//        if(clientOptional.isPresent() && employeeOptional.isPresent())
//        {
//            Resource employee=employeeOptional.get();
//            Clients client=clientOptional.get();
//            Set<Resource> s=client.getResourcec();
//            client.getResourcec().add(employee);
//            clientRepository.save(client);
//            return new ResponseEntity<Clients>(client, HttpStatus.CREATED);
//        }
//        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
//    }
//    public ResponseEntity<Set<Resource>> getResourcesOnProject(int projectId){
//        Optional<Project> projectOptional= Optional.ofNullable(this.projectRepository.findProjectById(projectId));
//        Set<Resource> list = new HashSet<>();
//        if(projectOptional.isPresent()){
//            Project project=projectOptional.get();
//            Set<Resource> s = project.getResource();
//
//        }
//        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
//    }
}
