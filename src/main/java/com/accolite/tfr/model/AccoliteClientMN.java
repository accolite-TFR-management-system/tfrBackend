package com.accolite.tfr.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "accolite_clientmn")
public class AccoliteClientMN {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;


//    @Column(name = "client_id")
//    private int client_id;
//    @Column(name = "resource_id")
//    private int resource_id;
    @Column(name = "status")
    private Boolean status;
    @Column(name = "date_of_add")
    private Date date_of_add;
//    @Column(name = "added_by")
//    private int added_by;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType. DETACH})
    @JoinColumn(name="client_id",referencedColumnName = "id")
    private Clients Client;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType. DETACH})
    @JoinColumn(name="added_by",referencedColumnName = "id")
    private Resource addedBy;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType. DETACH})
    @JoinColumn(name="resource_id",referencedColumnName = "id")
    private Resource resource;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
