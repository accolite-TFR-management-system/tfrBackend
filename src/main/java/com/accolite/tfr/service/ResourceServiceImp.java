package com.accolite.tfr.service;

import com.accolite.tfr.DTO.ClientsDTO;
import com.accolite.tfr.DTO.FeatureDTO;
import com.accolite.tfr.DTO.ProjectDTO;
import com.accolite.tfr.DTO.ResourceDTO;
import com.accolite.tfr.DTOmodel.ClientsModel;
import com.accolite.tfr.DTOmodel.FeatureModel;
import com.accolite.tfr.DTOmodel.ProjectModel;
import com.accolite.tfr.DTOmodel.ResourceModel;
import com.accolite.tfr.exception.Exception;
import com.accolite.tfr.model.*;
import com.accolite.tfr.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import javax.transaction.Transactional;
import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

@Service
@Transactional
public class ResourceServiceImp implements ResourceService{

    @Autowired
    private ResourceRepository resourceRepository;
    @Autowired
    private DesignationRepository designationRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private FeatureRepository featureRepository;
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private ResourceHistoryRepository resourceHistoryRepository;
    @Autowired(required=false)
    public ProjectDTO projectDTO;
    @Autowired(required = false)
    public ResourceDTO resourceDTO;
    @Autowired(required = false)
    public FeatureDTO featureDTO;
    @Autowired(required = false)
    public ClientsDTO clientsDTO;

    @Override
    public Resource addResource(ResourceModel resourceModel) {
        Resource resourceEntity = resourceDTO.modelToEntity(resourceModel);
        return resourceRepository.save(resourceEntity);
    }

    public ResponseEntity<ProjectModel> addEmployeeToProject(int employeeId, int projectId) {
        Optional<Resource> employeeOptional= Optional.ofNullable(this.resourceRepository.findResourceById(employeeId));
        Optional<Project> projectOptional= Optional.ofNullable(this.projectRepository.findProjectById(projectId));
        if(projectOptional.isPresent() && employeeOptional.isPresent())
        {
            Resource employee=employeeOptional.get();
            Project project=projectOptional.get();
            Set<Resource> s=project.getResource();
            project.getResource().add(employee);
            projectRepository.save(project);
            ProjectModel projectModel=this.projectDTO.entityToModel(project);
            return new ResponseEntity<ProjectModel>(projectModel, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<FeatureModel> addEmployeeToFeature(int resourceId, int featureId) {
        Optional<Resource> employeeOptional= Optional.ofNullable(this.resourceRepository.findResourceById(resourceId));
        Optional<Feature> FeatureOptional= Optional.ofNullable(this.featureRepository.findFeatureById(featureId));
        if(FeatureOptional.isPresent() && employeeOptional.isPresent())
        {
            Resource employee=employeeOptional.get();
            Feature feature=FeatureOptional.get();
            Set<Resource> s=feature.getResourcef();
            feature.getResourcef().add(employee);
            featureRepository.save(feature);
            FeatureModel featureModel=this.featureDTO.entityToModel(feature);
            return new ResponseEntity<FeatureModel>(featureModel, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);

    }

    public ResponseEntity<ClientsModel> addEmployeeToClient(int resourceId, int clientId) {
        Optional<Resource> employeeOptional= Optional.ofNullable(this.resourceRepository.findResourceById(resourceId));
        Optional<Clients> clientOptional= Optional.ofNullable(this.clientRepository.findClientsById(clientId));
        if(clientOptional.isPresent() && employeeOptional.isPresent())
        {
            Resource employee=employeeOptional.get();
            Clients client=clientOptional.get();
            Set<Resource> s=client.getResourcec();
            client.getResourcec().add(employee);
            clientRepository.save(client);
            ClientsModel clientsModel=this.clientsDTO.entityToModel(client);
            return new ResponseEntity<ClientsModel>(clientsModel, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    public List<Resource> findResourceByDesignationId(int desg_id) {
        List<Resource> resourceList = this.resourceRepository.findResourceByDesignationId(desg_id);
        return resourceList;
    }

    public List<Resource> getResources(int d_id) {
        Optional<Designation> newDesignation =this.designationRepository.findById(d_id);
        if(newDesignation.isPresent()) {
            Optional<List<Resource>> newList = Optional.ofNullable(this.resourceRepository.findResourceByDesignationId(d_id));
            if (newList.isPresent()) {
                return newList.get();
            } else {
                throw new Exception("Resources not found");
            }
        }
        else {
            throw new Exception("Designation not found");
        }
    }

    @Override
    public Resource getResource(int r_id) {
        Optional<Resource> newResource = Optional.ofNullable(this.resourceRepository.findResourceById(r_id));
        if(newResource.isPresent()){
            return newResource.get();
//            Resource r=newResource.get();
//            return this.resourceDTO.entityToModel(r);
        }
        else{
            throw new Exception("Resource not found");
        }
    }

//    public ResponseEntity<Set<ResourceModel>> getResourcesOnProject(int projectId){
//        Optional<Project> projectOptional= Optional.ofNullable(this.projectRepository.findProjectById(projectId));
////        Set<Resource> list = new HashSet<>();
//        if(projectOptional.isPresent()){
//            Project project=projectOptional.get();
//            Set<Resource> s = project.getResource();
//            Set<ResourceModel> resourceModel=this.resourceDTO.allEntitiesToModelsSet(s);
//            return new ResponseEntity<Set<ResourceModel>>(resourceModel, HttpStatus.CREATED);
//        }
//        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
//    }

    public ResponseEntity<?> updateResource(int resourceId, Map<Object,Object> fields) {
        Optional<Resource> getResource = Optional.ofNullable(this.resourceRepository.findResourceById(resourceId));
        if(getResource.isPresent()){
            fields.forEach((key,value)->{
                Field field = ReflectionUtils.findField(Resource.class,(String) key);
                field.setAccessible(true);
                ReflectionUtils.setField(field,getResource.get(),value);
            });
            Resource updateResource = resourceRepository.save(getResource.get());
            ResourceModel resourceModel=this.resourceDTO.entityToModel(updateResource);
            return new ResponseEntity<>(resourceModel,HttpStatus.OK);
        }
        else{
            throw new Exception("resource not found");
        }
    }

    public Boolean validateuser(ResourceModel l) {

        Resource ll=this.resourceDTO.modelToEntity(l);
        Resource lo=this.resourceRepository.findByEmail(ll.getEmail());
        if(lo!=null) {
            Resource newL=lo;
//			System.out.println(newL.getEmail()+" , "+newL.getPassword());
//			System.out.println(l.getEmail()+" , "+l.getPassword());
//			System.out.println(l.getPassword()==newL.getPassword());
            if(l.getPassword().equals(newL.getPassword())) return true;
            else return false;
        }
        else return false;
    }

    public ResponseEntity<Set<ResourceModel>> getResourcesOnProject(int projectId){
        Optional<Project> projectOptional= Optional.ofNullable(this.projectRepository.findProjectById(projectId));

        if(projectOptional.isPresent()){
            Project project=projectOptional.get();
            Set<Resource> s = project.getResource();
            Set<ResourceModel> sm=this.resourceDTO.allEntitiesToModelsSet(s);
            return new ResponseEntity<Set<ResourceModel>>(sm, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }


    public ResponseEntity<Set<FeatureModel>> getfeaturesForResources(int ResourceId) {
        Optional<Resource> employeeOptional= Optional.ofNullable(this.resourceRepository.findResourceById(ResourceId));
        if(employeeOptional.isPresent()){
            Resource resource = employeeOptional.get();
            Set<Feature> s = resource.getFeature();
            Set<FeatureModel> sm = this.featureDTO.allEntitiesToModelsSet(s);
            return  new  ResponseEntity<Set<FeatureModel>>(sm,HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<Set<ClientsModel>> getClientsForResources(int resourceId) {
        Optional<Resource> employeeOptional = Optional.ofNullable(this.resourceRepository.findResourceById(resourceId));
        if (employeeOptional.isPresent()) {
            Resource resource = employeeOptional.get();
            Set<Clients> s = resource.getClient();
            Set<ClientsModel> sm = this.clientsDTO.allEntitiesToModelsSet(s);
            return new ResponseEntity<Set<ClientsModel>>(sm, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    public ResourceHistory deleteEmployeeFromProject(int resourceId,int projectId) {
        Optional<Project> project=Optional.ofNullable(this.projectRepository.findProjectById(projectId));
        Optional<Resource> resource=Optional.ofNullable(this.resourceRepository.findResourceById(resourceId));
        if(project.isPresent() && resource.isPresent()) {
            Resource employee = resource.get();
            Project proj = project.get();
            LocalDate ld=LocalDate.now();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date date = new Date();
            Timestamp ts=new Timestamp(date.getTime());
            proj.getResource().remove(employee);
            ResourceHistory resourceHistory=new ResourceHistory();
            resourceHistory.setStart_date(employee.getJoin_date());
//            resourceHistory.setEnd_date();
//            resourceHistory.setDate_of_add();
            resourceHistory.setResourceHistoryProject(proj);
            resourceHistory.setResourceHistoryList(employee.getResourceList());
            resourceHistory.setRemark(employee.getRemark());
            resourceHistory.setResourceIdForHistory(employee);
            resourceHistoryRepository.save(resourceHistory);
            projectRepository.save(proj);
//            return ResponseEntity.ok().body(resourceHistory);
            return resourceHistory;
        } else {
            throw new Exception("Deletion not possible");
        }
    }
}
