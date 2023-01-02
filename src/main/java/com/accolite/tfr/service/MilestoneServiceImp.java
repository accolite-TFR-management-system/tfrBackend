package com.accolite.tfr.service;


import com.accolite.tfr.DTO.MilestoneDTO;
import com.accolite.tfr.DTOmodel.MilestoneModel;
import com.accolite.tfr.exception.Exception;
import com.accolite.tfr.model.Milestone;
import com.accolite.tfr.model.Project;
import com.accolite.tfr.repository.MilestoneRepository;
import com.accolite.tfr.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class MilestoneServiceImp implements MilestoneService{

    @Autowired
    private MilestoneRepository milestoneRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired(required = false)
    public MilestoneDTO milestoneDTO;

    public Milestone addMilestone(MilestoneModel od) {
        Milestone milestone=milestoneDTO.modelToEntity(od);
        return this.milestoneRepository.save(milestone);
    }


//    public List<Milestone> findMilestoneByProjectId(int proj_id) {
//        List<Milestone> ml= this.milestoneRepository.findMilestoneByProjectId(proj_id);
//        return ml;
//    }

    public List<Milestone> getMilestone(int p_id) {
        Optional<Project> project = Optional.ofNullable(this.projectRepository.findProjectById(p_id));
        if(project.isPresent()) {
            Optional<List<Milestone>> milestone = Optional.ofNullable(this.milestoneRepository.findMilestoneByPId(p_id));
            if (milestone.isPresent()) {
                List<Milestone> list = milestone.get();
                list.sort(Comparator.comparing(Milestone::getDate_of_add));
                return milestone.get();
            } else {
                throw new Exception("Milestone not found with project id : " + p_id);
            }
        }
        else {
            throw new Exception("Project not found with id : " + p_id);
        }
    }
}
