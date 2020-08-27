package com.ilya.sbt.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private String securitySocialNumber;
    LocalDateTime created;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Order> orders;

    public Client() {}

    public Client(Long id, String name) {
        this.id = id;
        this.name = name;
        securitySocialNumber = UUID.randomUUID().toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecuritySocialNumber() {
        return securitySocialNumber;
    }

    public void setSecuritySocialNumber(String securitySocialNumber) {
        this.securitySocialNumber = securitySocialNumber;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Column(name = "created", updatable = false)
    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    @PrePersist
    public void toCreate() {
        setCreated(LocalDateTime.now());
    }

}
