package com.accolite.tfr.service;

import com.accolite.tfr.DTO.ResourceHistoryDTO;
import com.accolite.tfr.DTOmodel.ResourceHistoryModel;
import com.accolite.tfr.exception.Exception;
import com.accolite.tfr.model.Project;
import com.accolite.tfr.model.Resource;
import com.accolite.tfr.model.ResourceHistory;
import com.accolite.tfr.repository.ProjectRepository;
import com.accolite.tfr.repository.ResourceHistoryRepository;
import com.accolite.tfr.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResourceHistoryServiceImp implements ResourceHistoryService{
    @Autowired
    private ResourceHistoryRepository resourceHistoryRepository;
    @Autowired
    private ResourceRepository resourceRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired(required = false)
    public ResourceHistoryDTO resourceHistoryDTO;

    public ResourceHistory addResourceHistory(ResourceHistoryModel od) {
        ResourceHistory resourceHistory = this.resourceHistoryDTO.modelToEntity(od);
        return this.resourceHistoryRepository.save(resourceHistory);
    }

    public List<ResourceHistory> getResourceHistoryByResourceId(int r_id) {
        Optional<Resource> newResource = Optional.ofNullable(this.resourceRepository.findResourceById(r_id));
        if(newResource.isPresent()) {
            Optional<List<ResourceHistory>> newList = Optional.ofNullable(this.resourceHistoryRepository.findResourceHistoryByResourceId(r_id));
            if (newList.isPresent()) {
                return newList.get();
            } else {
                throw new Exception("Resource HIstory  not found");
            }
        }
        else {
            throw new Exception("Resource not found");
        }
    }

    public List<ResourceHistory> getResourceHistoryByProjectId(int p_id) {
        Optional<Project> newProject = Optional.ofNullable(this.projectRepository.findProjectById(p_id));
        if(newProject.isPresent()) {
            Optional<List<ResourceHistory>> newList = Optional.ofNullable(this.resourceHistoryRepository.findResourceHistoryByProjectId(p_id));
            if (newList.isPresent()) {
                return newList.get();
            } else {
                throw new Exception("Resource History  not found");
            }
        }
        else {
            throw new Exception("Project not found");
        }
    }

}
