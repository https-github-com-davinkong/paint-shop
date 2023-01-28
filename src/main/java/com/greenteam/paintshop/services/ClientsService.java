package com.greenteam.paintshop.services;

import com.greenteam.paintshop.dtos.ClientsDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ClientsService {
    // add a client
    @Transactional
    void addClients(ClientsDto clientsDto);

    // delete a client by client id
    @Transactional
    void deleteClientsById(Long clientId);

    // update a client by client id
    @Transactional
    void updateClientsById(ClientsDto clientsDto);

    // get all clients
    List<ClientsDto> getAllClients();

    // get client by client id
    Optional<ClientsDto> getClientsById(Long clientId);
}
