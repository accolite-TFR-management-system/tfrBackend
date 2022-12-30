package com.accolite.tfr.service;

import com.accolite.tfr.DTO.ResourceHistoryDTO;
import com.accolite.tfr.DTOmodel.ResourceHistoryModel;
import com.accolite.tfr.entity.ResourceHistory;
import com.accolite.tfr.repository.ResourceHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResourceHistoryServiceImp implements ResourceHistoryService{
    @Autowired
    private ResourceHistoryRepository resourceHistoryRepository;
    @Autowired(required = false)
    public ResourceHistoryDTO resourceHistoryDTO;

    public ResourceHistory addResourceHistory(ResourceHistoryModel od) {
        ResourceHistory resourceHistory = this.resourceHistoryDTO.modelToEntity(od);
        return this.resourceHistoryRepository.save(resourceHistory);
    }



}
