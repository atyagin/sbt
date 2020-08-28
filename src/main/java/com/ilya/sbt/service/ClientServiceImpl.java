package com.ilya.sbt.service;

import com.ilya.sbt.domain.Client;
import com.ilya.sbt.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> clientList() {
        return clientRepository.findAll();
    }
}
