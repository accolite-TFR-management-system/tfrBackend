package com.accolite.tfr.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "resource_feature_mn")
public class ResourceFeatureMN {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType. DETACH})
    @JoinColumn(name="feature_id",referencedColumnName = "id")
    private List<Feature> feature;
//    @Column(name = "feature_id")
//    private int feature_id;
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType. DETACH})
    @JoinColumn(name="resource_id",referencedColumnName = "id")
    private List<Resource> resource;
//    @Column(name = "resource_id")
//    private int resource_id;

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
}
