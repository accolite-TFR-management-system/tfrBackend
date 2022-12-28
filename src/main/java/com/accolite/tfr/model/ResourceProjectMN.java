package com.accolite.tfr.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "ResourceProjectMN")
public class ResourceProjectMN {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "project_id")
    private int project_id;
    @Column(name = "resource_id")
    private int resource_id;

}
