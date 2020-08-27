package com.ilya.sbt.controller;

import com.ilya.sbt.domain.Client;
import com.ilya.sbt.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class MainController {
    @Autowired
    ClientService clientService;

    @GetMapping
    public List<Client> getClients() {
        return clientService.clientList();
    }
}
