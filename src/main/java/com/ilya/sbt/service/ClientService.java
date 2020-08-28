package com.ilya.sbt.service;

import com.ilya.sbt.dto.ClientDTO;

import java.util.List;

public interface ClientService {
    List<ClientDTO> clientList();
    ClientDTO getClient(Long id);
}
