package com.accolite.tfr.service;


import com.accolite.tfr.DTOmodel.ClientsModel;
import com.accolite.tfr.DTOmodel.FeatureModel;
import com.accolite.tfr.DTOmodel.ProjectModel;
import com.accolite.tfr.DTOmodel.ResourceModel;
import com.accolite.tfr.model.Clients;
import com.accolite.tfr.model.Feature;
import com.accolite.tfr.model.Project;
import com.accolite.tfr.model.Resource;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;

public interface ResourceService {

    public Resource addResource(ResourceModel resourceModel);
    //public List<Resource> findResourceByDesignationId(int desg_id);
    public List<Resource> getResources(int d_id);
    public ResourceModel getResource(int r_id);
    public ResponseEntity<ClientsModel> addEmployeeToClient(int resourceId, int clientId);
    public ResponseEntity<FeatureModel> addEmployeeToFeature(int resourceId, int featureId);
    public ResponseEntity<ProjectModel> addEmployeeToProject(int employeeId, int projectId);
    public ResponseEntity<Set<ResourceModel>> getResourcesOnProject(int projectId);
}
