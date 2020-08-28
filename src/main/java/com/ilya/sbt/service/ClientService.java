package com.ilya.sbt.service;

import com.ilya.sbt.domain.Client;
import com.ilya.sbt.domain.ClientPageDto;
import com.ilya.sbt.dto.ClientDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClientService {
    List<ClientDTO> clientList();
    ClientPageDto clientPageableList(Pageable pageable);
    ClientDTO getClient(Long id);
    Client saveClient(Client client);
    void deleteClient(Long id);
}
