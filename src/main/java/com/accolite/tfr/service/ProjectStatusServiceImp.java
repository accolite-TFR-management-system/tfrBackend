package com.accolite.tfr.service;

import com.accolite.tfr.DTO.ProjectStatusDTO;
import com.accolite.tfr.DTOmodel.ProjectStatusModel;
import com.accolite.tfr.exception.Exception;
import com.accolite.tfr.model.Project;
import com.accolite.tfr.model.ProjectStatus;
import com.accolite.tfr.repository.ProjectRepository;
import com.accolite.tfr.repository.ProjectStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectStatusServiceImp implements ProjectStatusService{

    @Autowired
    private ProjectStatusRepository projectStatusRepository;

    @Autowired
    private ProjectRepository projectRepository;
    @Autowired(required = false)
    public ProjectStatusDTO projectStatusDTO;

    public ProjectStatus addProjectStatus(ProjectStatusModel od) {
        ProjectStatus projectStatus = this.projectStatusDTO.modelToEntity(od);
        return this.projectStatusRepository.save(projectStatus);
    }

    public List<ProjectStatus> getProjectStatus(int p_id) {
        Optional<Project> newProject = Optional.ofNullable(this.projectRepository.findProjectById(p_id));
        if(newProject.isPresent()) {
            Optional<List<ProjectStatus>> newList = Optional.ofNullable(this.projectStatusRepository.findProjectStatusByProjectId(p_id));
            if (newList.isPresent()) {
                List<ProjectStatus> list = newList.get();
                list.sort(Comparator.comparing(ProjectStatus::getDate_of_add));
                return newList.get();
            } else {
                throw new Exception("project status not found");
            }
        }
        else {
            throw new Exception("project not found");
        }
    }
}
