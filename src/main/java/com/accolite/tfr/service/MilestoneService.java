package com.accolite.tfr.service;


import com.accolite.tfr.dto.MilestoneDto;
import com.accolite.tfr.model.Milestone;

public interface MilestoneService {

    public Milestone addMilestone(MilestoneDto orgDto);
    public MilestoneDto mapToDto(Milestone org);
    public Milestone mapToEntity(MilestoneDto od);
}
