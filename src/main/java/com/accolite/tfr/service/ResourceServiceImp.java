package com.accolite.tfr.service;

import com.accolite.tfr.dto.ResourceDto;
import com.accolite.tfr.model.Resource;
import com.accolite.tfr.repository.ResourceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResourceServiceImp implements ResourceService{

    @Autowired
    private ResourceRepository resourceRepository;
    @Autowired
    public ModelMapper modelMapper;

    public Resource addResource(ResourceDto od) {
        Resource resource = this.mapToEntity(od);
        return this.resourceRepository.save(resource);
    }

    public ResourceDto mapToDto(Resource org) {
        ResourceDto od = modelMapper.map(org,ResourceDto.class);
        return od;
    }

    public Resource mapToEntity(ResourceDto od) {
        Resource org = modelMapper.map(od, Resource.class);
        return org;
    }
}
