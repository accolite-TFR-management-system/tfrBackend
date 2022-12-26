package com.accolite.tfr.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Organisation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "department_type")
    private String department_type;
    @Column(name = "grandparent_id")
    private int grand_parent_id;
    @Column(name = "parent_id")
    private int parent_id;


//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
}
