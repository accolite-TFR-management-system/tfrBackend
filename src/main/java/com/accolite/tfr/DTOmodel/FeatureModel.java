package com.accolite.tfr.DTOmodel;

import com.accolite.tfr.model.ResourceFeatureMN;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FeatureModel {

    private int id;

    private  String feature;

    private List<ResourceFeatureMN> resourceFeatureMN;

}
