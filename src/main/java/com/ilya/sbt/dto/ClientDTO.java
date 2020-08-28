package com.ilya.sbt.dto;

import java.util.List;

public class ClientDTO {
    private Long id;
    private String name;
    private List<OrderDTO> orders;

    public ClientDTO() {}

    public ClientDTO(Long id, String name, List<OrderDTO> orders) {
        this.id = id;
        this.name = name;
        this.orders = orders;
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

    public List<OrderDTO> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderDTO> orders) {
        this.orders = orders;
    }
}
