package com.accolite.tfr.service;


import com.accolite.tfr.DTOmodel.ProjectStatusModel;
import com.accolite.tfr.model.ProjectStatus;

import java.util.List;

public interface ProjectStatusService {

    public ProjectStatus addProjectStatus(ProjectStatusModel orgDto);

    public List<ProjectStatus> getProjectStatus(int p_id);
}
