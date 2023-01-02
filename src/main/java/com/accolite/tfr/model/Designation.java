package com.accolite.tfr.model;


import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name ="designation")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property="id")
public class Designation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "designation_name")
    private String designation_name;
    @Column(name = "designation_code")
    private int designation_code;

//    @OneToMany(mappedBy = "ResourceList")
//    private List<Resource> ResourceList;

    @OneToMany(mappedBy = "ResourceHistoryList")
    @JsonIgnore
    private List<ResourceHistory> ResourceHistoryList;


    //new change
    @OneToMany(mappedBy = "ResourceList")
//    @JsonBackReference
    @JsonIgnore
//    @JsonBackReference(value="ResourceList")
    private List<Resource> ResourceList;

}
