package com.ilya.sbt.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private String securitySocialNumber;
    LocalDateTime created;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "client",  cascade = CascadeType.ALL)
    private List<Order> orders = new ArrayList<>();

    public Client() {}

    public Client(Long id, String name) {
        this.id = id;
        this.name = name;
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
        securitySocialNumber = UUID.randomUUID().toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id) &&
                Objects.equals(name, client.name) &&
                Objects.equals(securitySocialNumber, client.securitySocialNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, securitySocialNumber);
    }
}
