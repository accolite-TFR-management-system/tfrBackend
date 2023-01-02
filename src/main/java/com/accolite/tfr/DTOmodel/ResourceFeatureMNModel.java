package com.accolite.tfr.DTOmodel;

import com.accolite.tfr.model.Feature;
import com.accolite.tfr.model.Resource;
import lombok.Data;

import java.util.List;

@Data
public class ResourceFeatureMNModel {

    private int id;

    private List<Feature> feature;

    private List<Resource> resource;

}
