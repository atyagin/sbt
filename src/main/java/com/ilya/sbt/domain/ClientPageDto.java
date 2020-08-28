package com.ilya.sbt.domain;

import java.util.List;

public class ClientPageDto {
    private List<Client> clientList;
    private int currentPage;
    private int totalPages;

    public ClientPageDto() {}

    public ClientPageDto(List<Client> clientList, int currentPage, int totalPages) {
        this.clientList = clientList;
        this.currentPage = currentPage;
        this.totalPages = totalPages;
    }
}
