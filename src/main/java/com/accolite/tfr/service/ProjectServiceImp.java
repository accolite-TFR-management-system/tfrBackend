package com.accolite.tfr.service;


import com.accolite.tfr.dto.OrganisationDto;
import com.accolite.tfr.dto.ProjectDto;
import com.accolite.tfr.model.Organisation;
import com.accolite.tfr.model.Project;
import com.accolite.tfr.repository.ProjectRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImp implements ProjectService{
    @Autowired
    public ProjectRepository projectRepository;
    @Autowired
    public ModelMapper modelMapper;

    public ProjectDto mapToDto(Project org) {
        ProjectDto od = modelMapper.map(org,ProjectDto.class);
        return od;
    }

    public Project mapToEntity(ProjectDto od) {
        Project org = modelMapper.map(od, Project.class);
        return org;
    }

    public Project addProject(ProjectDto projectDto) {
        Project project= this.mapToEntity(projectDto);
        return this.projectRepository.save(project);
    }


}
