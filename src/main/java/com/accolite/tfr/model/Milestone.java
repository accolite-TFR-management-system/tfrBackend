package com.accolite.tfr.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "milestone")
public class Milestone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "start_date")
    private Date start_date;
    @Column(name = "end_date")
    private Date end_date;
    @Column(name = "status")
    private String status;
//    @Column(name = "created_by")
//    private int created_by;
    @Column(name = "date_of_add")
    private Date date_of_add;
    @Column(name = "weightage")
    private int weightage;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType. DETACH})
    @JoinColumn(name="created_by",referencedColumnName = "id")
    private Resource resource;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType. DETACH})
    @JoinColumn(name="project_id",referencedColumnName = "id")
    private Project project;
    @OneToMany(mappedBy = "Goals")
    private List<Goals> GoalList;
    public int getId() {
        return id;
    }

//    public void setId(int id) {
//        this.id = id;
//    }
}
