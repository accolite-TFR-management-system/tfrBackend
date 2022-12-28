package com.accolite.tfr.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="feature")
public class Feature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "feature")
    private  String feature;
    @ManyToMany(mappedBy = "feature")
    private List<ResourceFeatureMN> resourceFeatureMN;
//    @Column(name = "feature_name")
//    private String feature_name;

}
