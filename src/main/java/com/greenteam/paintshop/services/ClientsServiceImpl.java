package com.greenteam.paintshop.services;

import com.greenteam.paintshop.dtos.ClientsDto;
import com.greenteam.paintshop.entities.Clients;
import com.greenteam.paintshop.repositories.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientsServiceImpl implements ClientsService {

    @Autowired
    private ClientsRepository clientsRepository;

    // add a client
    @Override
    @Transactional
    public void addClients(ClientsDto clientsDto){
        Clients clients = new Clients(clientsDto);
        clientsRepository.saveAndFlush(clients);
        // System.out.println("client saved" + clients);
    }

    // delete a client by client id
    @Override
    @Transactional
    public void deleteClientsById(Long clientId){
        Optional<Clients> clientsOptional = clientsRepository.findById(clientId);
        clientsOptional.ifPresent(clients -> clientsRepository.delete(clients));
    }

    // update a client by client id
    @Override
    @Transactional
    public void updateClientsById(ClientsDto clientsDto){
        Optional<Clients> clientsOptional = clientsRepository.findById(clientsDto.getId());
        clientsOptional.ifPresent(clients -> {
            clients.setFirstName(clientsDto.getFirstName());
            clients.setLastName(clientsDto.getLastName());
            clientsRepository.saveAndFlush(clients);
        });
    }

    // get all clients
    @Override
    public List<ClientsDto> getAllClients(){
        List<Clients> clientsList = clientsRepository.findAll();
        return clientsList.stream().map(clients -> new ClientsDto(clients)).collect(Collectors.toList());
    }

    // get client by client id
    @Override
    public Optional<ClientsDto> getClientsById(Long clientId){
        Optional<Clients> clientsOptional = clientsRepository.findById(clientId);
        if(clientsOptional.isPresent()){
            return Optional.of(new ClientsDto(clientsOptional.get()));
        }
        return Optional.empty();
    }

}







