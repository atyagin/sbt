package com.ilya.sbt.mapper;

import com.ilya.sbt.domain.Client;
import com.ilya.sbt.dto.ClientDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientDTO toDto(Client client);
    List <ClientDTO> toDtoList(List<Client> clientList);
}
