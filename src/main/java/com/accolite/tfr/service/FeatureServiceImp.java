package com.accolite.tfr.service;

import com.accolite.tfr.DTO.FeatureDTO;
import com.accolite.tfr.DTOmodel.FeatureModel;
import com.accolite.tfr.model.Feature;
import com.accolite.tfr.repository.FeatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeatureServiceImp implements FeatureService{
    @Autowired
    private FeatureRepository featureRepository;
    @Autowired(required = false)
    public FeatureDTO featureDTO;

    public Feature addFeature(FeatureModel od) {
        Feature feature=featureDTO.modelToEntity(od);
        return this.featureRepository.save(feature);
    }



}
