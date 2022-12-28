package com.accolite.tfr.service;

import com.accolite.tfr.dto.FeatureDto;
import com.accolite.tfr.model.Feature;
import com.accolite.tfr.repository.FeatureRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeatureServiceImp implements FeatureService{
    @Autowired
    private FeatureRepository featureRepository;
    @Autowired
    public ModelMapper modelMapper;

    public Feature addFeature(FeatureDto od) {
        Feature feature = this.mapToEntity(od);
        return this.featureRepository.save(feature);
    }

    public FeatureDto mapToDto(Feature org) {
        FeatureDto od = modelMapper.map(org,FeatureDto.class);
        return od;
    }

    public Feature mapToEntity(FeatureDto od) {
        Feature org = modelMapper.map(od, Feature.class);
        return org;
    }

}
