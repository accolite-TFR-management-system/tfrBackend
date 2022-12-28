package com.accolite.tfr.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="organization")
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


    @OneToMany(mappedBy = "department")
//    @JsonBackReference(value="department")
    private List<Project> departmentList;
    @OneToMany(mappedBy = "superDepartment")
//    @JsonBackReference(value="department")
    private List<Project> superDepartmentList;
    @OneToMany(mappedBy = "division")
//    @JsonBackReference(value="department")
    private List<Project> divisionList;

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
}
