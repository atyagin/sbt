package com.ilya.sbt.domain;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "order_table")
public class Order {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String description;
    private String responsible;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clientId")
    private Client client;

    public Order() {}

    public Order(Long id, String description, Client client) {
        this.id = id;
        this.description = description;
        responsible = UUID.randomUUID().toString();
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
