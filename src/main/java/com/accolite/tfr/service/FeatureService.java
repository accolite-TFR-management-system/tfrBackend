package com.accolite.tfr.service;


import com.accolite.tfr.DTOmodel.FeatureModel;
import com.accolite.tfr.entity.Feature;

public interface FeatureService {

    public Feature addFeature(FeatureModel orgDto);

}
