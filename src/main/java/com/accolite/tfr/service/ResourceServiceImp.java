package com.accolite.tfr.service;

import com.accolite.tfr.DTO.ResourceDTO;
import com.accolite.tfr.DTOmodel.ResourceModel;
import com.accolite.tfr.entity.Resource;
import com.accolite.tfr.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ResourceServiceImp implements ResourceService{

    @Autowired
    private ResourceRepository resourceRepository;
    @Autowired(required = false)
    public ResourceDTO resourceDTO;

    @Override
    public Resource addResource(ResourceModel resourceModel) {
        Resource resourceEntity = resourceDTO.modelToEntity(resourceModel);
        return resourceRepository.save(resourceEntity);
    }

    public List<Resource> findResourceByDesignationId(int desg_id) {
        List<Resource> resourceList = this.resourceRepository.findResourceByDesignationId(desg_id);
        return resourceList;
    }
}
