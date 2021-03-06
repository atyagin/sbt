package com.ilya.sbt.controller;

import com.ilya.sbt.domain.Client;
import com.ilya.sbt.domain.ClientPageDto;
import com.ilya.sbt.dto.ClientDTO;
import com.ilya.sbt.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {
    public static final int CLIENT_PER_PAGE = 2;

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<List<ClientDTO>> getClients() {
        List<ClientDTO> clientDTOList = clientService.clientList();
        if (clientDTOList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(clientDTOList, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<ClientPageDto> getClients(@PageableDefault(size = CLIENT_PER_PAGE, sort = { "id" }, direction = Sort.Direction.ASC) Pageable pageable) {
        ClientPageDto clientPageDto = clientService.clientPageableList(pageable);

        if (clientPageDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(clientPageDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> getClient(@PathVariable Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        ClientDTO clientDTO = clientService.getClient(id);

        if (clientDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(clientDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Client> addClient(@RequestBody @Valid Client client) {
        if (client == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        clientService.saveClient(client);
        return new ResponseEntity<>(client, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Client> updateClient(@RequestBody @Valid Client client) {
        if (client == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        clientService.saveClient(client);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        clientService.deleteClient(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
