package com.accolite.tfr.service;


import com.accolite.tfr.DTOmodel.MilestoneModel;
import com.accolite.tfr.model.Milestone;

import java.util.List;

public interface MilestoneService {

    public Milestone addMilestone(MilestoneModel orgDto);

//    public List<Milestone> findMilestoneByProjectId(int proj_id);

    public List<Milestone> getMilestone(int p_id);
}
