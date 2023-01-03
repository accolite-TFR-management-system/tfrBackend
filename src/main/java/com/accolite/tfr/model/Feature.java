package com.accolite.tfr.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
//    @ManyToMany(mappedBy = "feature")
//    @JsonIgnore
//    private List<ResourceFeatureMN> resourceFeatureMN;
//    @Column(name = "feature_name")
//    private String feature_name;

    @ManyToMany(fetch = FetchType.LAZY,cascade = { CascadeType.ALL })
    @JoinTable(
            name = "resource_feature_mn_table",
            joinColumns = { @JoinColumn(name = "feature_id") },
            inverseJoinColumns = { @JoinColumn(name = "resource_id") }
    )
    //@JsonManagedReference
    private Set<Resource> resourcef = new HashSet<>();

    @JsonIgnore
    public Set<Resource> getResourcef() {
        return resourcef;
    }

    public void setResourcef(Set<Resource> features) {
        this.resourcef = features;
    }
}
