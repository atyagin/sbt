package com.ilya.sbt.service;

import com.ilya.sbt.domain.Client;
import com.ilya.sbt.dto.ClientDTO;

import java.util.List;

public interface ClientService {
    public List<ClientDTO> clientList();
    public ClientDTO getClient(Long id);
}
