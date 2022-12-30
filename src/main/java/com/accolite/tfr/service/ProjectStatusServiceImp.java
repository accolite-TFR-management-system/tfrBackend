package com.accolite.tfr.service;

import com.accolite.tfr.DTO.ProjectStatusDTO;
import com.accolite.tfr.DTOmodel.ProjectStatusModel;
import com.accolite.tfr.entity.ProjectStatus;
import com.accolite.tfr.repository.ProjectStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectStatusServiceImp implements ProjectStatusService{

    @Autowired
    private ProjectStatusRepository projectStatusRepository;
    @Autowired(required = false)
    public ProjectStatusDTO projectStatusDTO;

    public ProjectStatus addProjectStatus(ProjectStatusModel od) {
        ProjectStatus projectStatus = this.projectStatusDTO.modelToEntity(od);
        return this.projectStatusRepository.save(projectStatus);
    }


}
