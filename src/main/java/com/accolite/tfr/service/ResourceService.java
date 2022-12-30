package com.accolite.tfr.service;


import com.accolite.tfr.DTOmodel.ResourceModel;
import com.accolite.tfr.entity.Resource;

import java.util.List;

public interface ResourceService {

    public Resource addResource(ResourceModel resourceModel);
    public List<Resource> findResourceByDesignationId(int desg_id);
}
