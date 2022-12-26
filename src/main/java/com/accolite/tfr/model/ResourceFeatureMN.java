package com.accolite.tfr.model;

import lombok.Data;

import javax.persistence.Column;

@Data
public class ResourceFeatureMN {
    @Column(name = "feature_id")
    private int feature_id;
    @Column(name = "resource_id")
    private int resource_id;
}
