package com.accolite.tfr.DTOmodel;

import com.accolite.tfr.model.ResourceFeatureMN;
import lombok.Data;

import java.util.List;

@Data
public class FeatureModel {

    private int id;

    private  String feature;

    private List<ResourceFeatureMN> resourceFeatureMN;

}
