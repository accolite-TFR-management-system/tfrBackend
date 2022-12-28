package com.accolite.tfr.service;

import com.accolite.tfr.exception.Exception;
import com.accolite.tfr.model.*;
import com.accolite.tfr.repository.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

//import org.springframework.stereotype.Service
@org.springframework.stereotype.Service
public class Service {
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

//    public Project addProject(Project project) {
//        return this.projectRepository.save(project);
//    }

//    public Feature getFeature(int feature_id) {
//        Feature feature = this.featureRepository.findById(feature_id);
//    }
}
