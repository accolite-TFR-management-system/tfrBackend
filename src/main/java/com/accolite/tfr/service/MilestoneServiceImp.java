package com.accolite.tfr.service;


import com.accolite.tfr.DTO.MilestoneDTO;
import com.accolite.tfr.DTOmodel.MilestoneModel;
import com.accolite.tfr.entity.Milestone;
import com.accolite.tfr.repository.MilestoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MilestoneServiceImp implements MilestoneService{

    @Autowired
    private MilestoneRepository milestoneRepository;
    @Autowired(required = false)
    public MilestoneDTO milestoneDTO;

    public Milestone addMilestone(MilestoneModel od) {
        Milestone milestone=milestoneDTO.modelToEntity(od);
        return this.milestoneRepository.save(milestone);
    }


    public List<Milestone> findMilestoneByProjectId(int proj_id) {
        List<Milestone> ml= this.milestoneRepository.findMilestoneByProjectId(proj_id);
        return ml;
    }
}
