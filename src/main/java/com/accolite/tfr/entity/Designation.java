package com.accolite.tfr.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name ="designation")
public class Designation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "designation_name")
    private String designation_name;
    @Column(name = "designation_code")
    private int designation_code;

    @OneToMany(mappedBy = "ResourceList")
    @JsonIgnore
    private List<Resource> ResourceList;

    @OneToMany(mappedBy = "ResourceHistoryList")
    @JsonIgnore
    private List<ResourceHistory> ResourceHistoryList;

}
