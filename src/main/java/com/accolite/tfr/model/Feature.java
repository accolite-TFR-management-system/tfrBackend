package com.accolite.tfr.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Feature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "feature")
    private  String feature;
//    @Column(name = "feature_name")
//    private String feature_name;

}
