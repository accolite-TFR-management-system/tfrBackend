package com.accolite.tfr.service;


import com.accolite.tfr.DTOmodel.ResourceHistoryModel;
import com.accolite.tfr.entity.ResourceHistory;

public interface ResourceHistoryService {

    public ResourceHistory addResourceHistory(ResourceHistoryModel orgDto);

}
