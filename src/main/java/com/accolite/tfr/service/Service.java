package com.accolite.tfr.service;

import com.accolite.tfr.exception.Exception;
import com.accolite.tfr.model.Feature;
import com.accolite.tfr.model.Organisation;
import com.accolite.tfr.model.Project;
import com.accolite.tfr.repository.FeatureRepository;
import com.accolite.tfr.repository.OrganisationRepository;
import com.accolite.tfr.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

//import org.springframework.stereotype.Service
@org.springframework.stereotype.Service
public class Service {
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private FeatureRepository featureRepository;
    @Autowired
    private OrganisationRepository organisationRepository;

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

//    public Project addProject(Project project) {
//        return this.projectRepository.save(project);
//    }

//    public Feature getFeature(int feature_id) {
//        Feature feature = this.featureRepository.findById(feature_id);
//    }
}
