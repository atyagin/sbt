package com.ilya.sbt.controller;

import com.ilya.sbt.domain.Client;
import com.ilya.sbt.dto.ClientDTO;
import com.ilya.sbt.mapper.ClientMapper;
import com.ilya.sbt.service.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class MainController {
    @Autowired
    private ClientServiceImpl clientService;

    @Autowired
    private ClientMapper clientMapper;

    @GetMapping("/clients/")
    public List<ClientDTO> getClients() {
        List<Client> clients = clientService.clientList();
        return clientMapper.toDtoList(clients);
    }

    @GetMapping("/clients/{id}")
    public ClientDTO getClient(@PathVariable Long id) {
        Client client = clientService.getClient(id);
        return clientMapper.toDto(client);
    }
}
