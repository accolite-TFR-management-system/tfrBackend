package com.accolite.tfr.DTOmodel;

import com.accolite.tfr.entity.Feature;
import com.accolite.tfr.entity.Resource;
import lombok.Data;

import java.util.List;

@Data
public class ResourceFeatureMNModel {

    private int id;

    private List<Feature> feature;

    private List<Resource> resource;

}
