package com.accolite.tfr.service;


import com.accolite.tfr.dto.FeatureDto;
import com.accolite.tfr.model.Feature;

public interface FeatureService {

    public Feature addFeature(FeatureDto orgDto);
    public FeatureDto mapToDto(Feature org);
    public Feature mapToEntity(FeatureDto od);
}
