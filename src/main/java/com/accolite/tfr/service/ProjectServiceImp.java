package com.accolite.tfr.service;


import com.accolite.tfr.DTOmodel.ResourceModel;
import com.accolite.tfr.exception.Exception;
import com.accolite.tfr.DTO.ProjectDTO;
import com.accolite.tfr.DTOmodel.ProjectModel;
import com.accolite.tfr.model.Clients;
import com.accolite.tfr.model.Organisation;
import com.accolite.tfr.model.Project;
import com.accolite.tfr.model.Resource;
import com.accolite.tfr.repository.ClientRepository;
import com.accolite.tfr.repository.OrganisationRepository;
import com.accolite.tfr.repository.ProjectRepository;
import com.accolite.tfr.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.*;

@Service
public class ProjectServiceImp implements ProjectService{
    @Autowired
    public ClientRepository clientRepository;
    @Autowired
    public ProjectRepository projectRepository;
    @Autowired
    public OrganisationRepository organisationRepository;
    @Autowired
    public ResourceRepository resourceRepository;
    @Autowired(required = false)
    public ProjectDTO projectDTO;

    public Project addProject(ProjectModel projectModel) {
        Project project= this.projectDTO.modelToEntity(projectModel);
        return this.projectRepository.save(project);
    }

    public Project getProject(int p_id) {

        Optional<Project> project = Optional.ofNullable(this.projectRepository.findProjectById(p_id));
//        Project projectModel=projectDTO.modelToEntity(project);
        if(project.isPresent()) {
            return project.get();
        }
        else {
            throw new Exception("Project not found");
        }
    }
    public List<Project> getProjectByCid(int c_id) {
        Optional<Clients>  getClient = Optional.ofNullable(this.clientRepository.findClientsById(c_id));
        if(getClient.isPresent()){
            Clients client = getClient.get();
            List<Project> list = this.projectRepository.findAllByClientId(c_id);
            if(list.size()!=0){
                return list;
            }
            else {
                return null;
            }
        }
        else{
            throw new Exception("client not found");
        }
    }


    public List<Project> getAllProjects() {
        return this.projectRepository.findAll();
    }

    public ResponseEntity<List<ProjectModel>> getAllProjectSortedByDate() {
        List<Project> projectList = this.projectRepository.findAll() ;
        for(int i=0 ; i<projectList.size() ; i++){
            if(projectList.get(i).getCurrent_pointer()==0){
                projectList.remove(i);
                i=i-1;
            }
        }
        projectList.sort(Comparator.comparing(Project::getDate_of_add));
        List<ProjectModel> projectModels=this.projectDTO.allEntitiesToModels(projectList);
        return  new ResponseEntity<List<ProjectModel>>(projectModels, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ProjectModel> updateProject(ProjectModel projectModel, int projectId) {
        Project project= this.projectDTO.modelToEntity(projectModel);
        Optional<Project> oldProject = Optional.ofNullable(this.projectRepository.findProjectById(projectId));
        Project newProject = this.projectRepository.save(project);
        if(oldProject.isPresent()){
            Date date = new Date();
            Timestamp ts=new Timestamp(date.getTime());
            Project oldProjectRecord = oldProject.get();
            oldProjectRecord.setEnd_date(ts);
            newProject.setParent_id(oldProjectRecord.getId());
            newProject.setCurrent_pointer(1);
        }
        ProjectModel projectModel1=this.projectDTO.entityToModel(newProject);
        return new ResponseEntity<ProjectModel>(projectModel1, HttpStatus.OK);
    }
//    public List<Project> getProjectByCid(int c_id) {
//        Optional<Clients>  getClient = Optional.ofNullable(this.clientRepository.findClientsById(c_id));
//        if(getClient.isPresent()){
//            Clients client = getClient.get();
//            List<Project> list = this.projectRepository.findAllByClientId(c_id);
//            if(list.size()!=0){
//                return list;
//            }
//            else {
//                return null;
//            }
//        }else{
//            throw new Exception("client not found");
//        }
//    }
    @Override
    public ResponseEntity<List<Project>> getProjectByOrgId(int o_id) {
        Optional<Organisation> getOrg = this.organisationRepository.findByOrgId(o_id);
        if(getOrg.isPresent()){
            Organisation org = getOrg.get();
            List<Project> getList = this.projectRepository.findByOrgId(o_id);
            if(getList.size()!=0){
                return new ResponseEntity<List<Project>>(getList,HttpStatus.OK);
            }
            return null;
        }
        else {
            throw new Exception("Org not found");
        }
    }
    public ResponseEntity<?> updateProj(int projectId, Map<Object,Object> fields) {
        Optional<Project> getProject = Optional.ofNullable(this.projectRepository.findProjectById(projectId));
        if(getProject.isPresent()){
            fields.forEach((key,value)->{
                Field field = ReflectionUtils.findField(Project.class,(String) key);
                field.setAccessible(true);
                ReflectionUtils.setField(field,getProject.get(),value);
            });
            Project updateProj = projectRepository.save(getProject.get());
            ProjectModel projectModel=this.projectDTO.entityToModel(updateProj);
            return new ResponseEntity<>(projectModel,HttpStatus.OK);
        }
        else{
            throw new Exception("project not found");
        }
    }

    public ResponseEntity<List<ProjectModel>> getProjectByRid(int r_id) {
        Optional<Resource> resource = Optional.ofNullable(this.resourceRepository.findResourceById(r_id));
        List<Project> list = new ArrayList<>();
        if(resource.isPresent()){
            Resource getResource = resource.get();
            Set<Project> s = getResource.getProject();
            for (Project p : s) {
                list.add(p);
            }
            for(int i = 0 ; i<list.size();i++){
                if(list.get(i).getCurrent_pointer()==0) {
                    list.remove(i);
                    i=i-1;
                }
            }
            List<ProjectModel> projectModels=this.projectDTO.allEntitiesToModels(list);
            return  new  ResponseEntity<List<ProjectModel>>(projectModels,HttpStatus.OK);
        }
        else{
            throw new Exception("resource not found");
        }
    }
}
