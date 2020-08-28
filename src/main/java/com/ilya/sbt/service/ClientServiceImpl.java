package com.ilya.sbt.service;

import com.ilya.sbt.domain.Client;
import com.ilya.sbt.domain.ClientPageDto;
import com.ilya.sbt.dto.ClientDTO;
import com.ilya.sbt.mapper.ClientMapper;
import com.ilya.sbt.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    @Override
    public List<ClientDTO> clientList() {
        List<Client> clientList = clientRepository.findAll();
        return clientMapper.toDtoList(clientList);
    }

    @Override
    public ClientPageDto clientPageableList(Pageable pageable) {
        Page<Client> page = clientRepository.findAll(pageable);
        return new ClientPageDto(page.getContent(), pageable.getPageNumber(), page.getTotalPages());
    }

    @Override
    public ClientDTO getClient(Long id) {
        Client client = clientRepository.getClientById(id);
        return clientMapper.toDto(client);
    }

    @Override
    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
