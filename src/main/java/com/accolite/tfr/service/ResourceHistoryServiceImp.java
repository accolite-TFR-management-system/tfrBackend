package com.accolite.tfr.service;

import com.accolite.tfr.dto.ResourceHistoryDto;
import com.accolite.tfr.model.ResourceHistory;
import com.accolite.tfr.repository.ResourceHistoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResourceHistoryServiceImp implements ResourceHistoryService{
    @Autowired
    private ResourceHistoryRepository resourceHistoryRepository;
    @Autowired
    public ModelMapper modelMapper;

    public ResourceHistory addResourceHistory(ResourceHistoryDto od) {
        ResourceHistory resourceHistory = this.mapToEntity(od);
        return this.resourceHistoryRepository.save(resourceHistory);
    }

    public ResourceHistoryDto mapToDto(ResourceHistory org) {
        ResourceHistoryDto od = modelMapper.map(org,ResourceHistoryDto.class);
        return od;
    }

    public ResourceHistory mapToEntity(ResourceHistoryDto od) {
        ResourceHistory org = modelMapper.map(od, ResourceHistory.class);
        return org;
    }

}
