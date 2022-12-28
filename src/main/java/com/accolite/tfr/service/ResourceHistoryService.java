package com.accolite.tfr.service;


import com.accolite.tfr.dto.ResourceHistoryDto;
import com.accolite.tfr.model.ResourceHistory;

public interface ResourceHistoryService {

    public ResourceHistory addResourceHistory(ResourceHistoryDto orgDto);
    public ResourceHistoryDto mapToDto(ResourceHistory org);
    public ResourceHistory mapToEntity(ResourceHistoryDto od);
}
