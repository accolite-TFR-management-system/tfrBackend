package com.accolite.tfr.service;


import com.accolite.tfr.DTOmodel.MilestoneModel;
import com.accolite.tfr.model.Milestone;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface MilestoneService {

    public Milestone addMilestone(MilestoneModel orgDto);

//    public List<Milestone> findMilestoneByProjectId(int proj_id);

    public List<Milestone> getMilestone(int p_id);
    public ResponseEntity<?> updateMilestone(int milestoneId, Map<Object, Object> fields);
}
