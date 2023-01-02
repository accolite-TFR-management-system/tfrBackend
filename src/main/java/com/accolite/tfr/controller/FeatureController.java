package com.accolite.tfr.controller;


import com.accolite.tfr.DTO.FeatureDTO;
import com.accolite.tfr.model.Feature;
import com.accolite.tfr.DTOmodel.FeatureModel;
import com.accolite.tfr.repository.FeatureRepository;
import com.accolite.tfr.service.FeatureServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tfr")
public class FeatureController {

    @Autowired
    private FeatureRepository featureRepository;

    @Autowired
    private FeatureServiceImp featureServiceImp;

    @Autowired(required = false)
    public FeatureDTO featureDTO;

    @PostMapping("/addFeature")
    ResponseEntity<FeatureModel> addFeature(@RequestBody FeatureModel featureModel) {
        Feature feature=featureServiceImp.addFeature(featureModel);
        FeatureModel featureModel1=featureDTO.entityToModel(feature);
        return ResponseEntity.ok().body(featureModel1);
    }
}
