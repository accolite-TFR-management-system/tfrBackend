package com.accolite.tfr.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class AccoliteClientMN {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    private int client_id;
    private int resource_id;
    private Boolean status;
    private Date date_of_add;
    private int added_by;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
