package com.accolite.tfr.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Designation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "designation_name")
    private String designation_name;
    @Column(name = "designation_code")
    private int designation_code;
}
