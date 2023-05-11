package com.example.hackaton.model;

import javax.persistence.*;

@Entity
public class Device {
    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name="client_id", nullable=false)
    private Client client;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
