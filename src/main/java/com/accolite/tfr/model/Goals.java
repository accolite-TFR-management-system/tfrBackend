package com.accolite.tfr.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "goals")
public class Goals {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
//    @Column(name = "milestone_id")
//    private int milestone_id;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType. DETACH})
    @JoinColumn(name="milestone_id",referencedColumnName = "id")
    private Milestone Milestone;

    @Column(name = "goal_name")
    private String name;
    @Column(name = "goal_description")
    private String goal_description;
    @Column(name = "goal_status")
    private String goal_status;
    @Column(name = "date_of_add",nullable = false, updatable = false)
    @CreationTimestamp
    private Date date_of_add;
    @Column(name = "start_date")
    private Date start_date;
    @Column(name = "end_date")
    private Date end_date;
//    @Column(name = "created_by")
//    private int created_by;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType. DETACH})
    @JoinColumn(name="created_by",referencedColumnName = "id")
    private Resource CreatedBy;


//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
}
