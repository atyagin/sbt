package com.ilya.sbt.repository;

import com.ilya.sbt.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Client getClientById(Long id);
}
