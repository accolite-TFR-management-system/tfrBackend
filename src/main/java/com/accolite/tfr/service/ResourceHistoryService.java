package com.accolite.tfr.service;


import com.accolite.tfr.DTOmodel.ResourceHistoryModel;
import com.accolite.tfr.model.ResourceHistory;

import java.util.List;

public interface ResourceHistoryService {

    public ResourceHistory addResourceHistory(ResourceHistoryModel orgDto);

    public List<ResourceHistory> getResourceHistoryByResourceId(int r_id);

    public List<ResourceHistory> getResourceHistoryByProjectId(int p_id);

}
