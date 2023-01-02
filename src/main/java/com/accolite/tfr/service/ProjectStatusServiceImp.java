package com.accolite.tfr.service;

import com.accolite.tfr.dto.ProjectStatusDto;
import com.accolite.tfr.model.ProjectStatus;
import com.accolite.tfr.repository.ProjectStatusRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectStatusServiceImp implements ProjectStatusService{

    @Autowired
    private ProjectStatusRepository projectStatusRepository;
    @Autowired
    public ModelMapper modelMapper;

    public ProjectStatus addProjectStatus(ProjectStatusDto od) {
        ProjectStatus projectStatus = this.mapToEntity(od);
        return this.projectStatusRepository.save(projectStatus);
    }

    public ProjectStatusDto mapToDto(ProjectStatus org) {
        ProjectStatusDto od = modelMapper.map(org,ProjectStatusDto.class);
        return od;
    }

    public ProjectStatus mapToEntity(ProjectStatusDto od) {
        ProjectStatus org = modelMapper.map(od, ProjectStatus.class);
        return org;
    }
}
