package com.ilya.sbt.service;

import com.ilya.sbt.domain.Client;

import java.util.List;

public interface ClientService {
    public List<Client> clientList();
    public Client getClient(Long id);
}
