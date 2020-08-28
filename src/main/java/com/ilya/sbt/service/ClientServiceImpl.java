package com.ilya.sbt.service;

import com.ilya.sbt.domain.Client;
import com.ilya.sbt.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ClientServiceImpl implements ClientService {
    ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Client> clientList() {
        return clientRepository.findAll();
    }

    @Override
    public Client getClient(Long id) {
        return clientRepository.getClientById(id);
    }
}
