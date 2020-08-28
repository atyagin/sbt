package com.ilya.sbt.repository;

import com.ilya.sbt.domain.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Client getClientById(Long id);
    Page<Client> findAll(Pageable pageable);
}
