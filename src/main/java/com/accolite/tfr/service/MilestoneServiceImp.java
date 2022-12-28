package com.accolite.tfr.service;


import com.accolite.tfr.dto.MilestoneDto;
import com.accolite.tfr.model.Milestone;
import com.accolite.tfr.repository.MilestoneRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MilestoneServiceImp implements MilestoneService{

    @Autowired
    private MilestoneRepository milestoneRepository;
    @Autowired
    public ModelMapper modelMapper;

    public Milestone addMilestone(MilestoneDto od) {
        Milestone milestone = this.mapToEntity(od);
        return this.milestoneRepository.save(milestone);
    }

    public MilestoneDto mapToDto(Milestone org) {
        MilestoneDto od = modelMapper.map(org,MilestoneDto.class);
        return od;
    }

    public Milestone mapToEntity(MilestoneDto od) {
        Milestone org = modelMapper.map(od, Milestone.class);
        return org;
    }
}
