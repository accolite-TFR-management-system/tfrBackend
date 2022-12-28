package com.accolite.tfr.service;


import com.accolite.tfr.dto.ResourceDto;
import com.accolite.tfr.model.Resource;

public interface ResourceService {

    public Resource addResource(ResourceDto orgDto);
    public ResourceDto mapToDto(Resource org);
    public Resource mapToEntity(ResourceDto od);
}
