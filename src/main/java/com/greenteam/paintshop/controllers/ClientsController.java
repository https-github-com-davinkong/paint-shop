package com.greenteam.paintshop.controllers;

import com.greenteam.paintshop.dtos.ClientsDto;
import com.greenteam.paintshop.dtos.ContractorsDto;
import com.greenteam.paintshop.services.ClientsService;
import com.greenteam.paintshop.services.ContractorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/clients")
public class ClientsController {
    @Autowired
    private ClientsService clientsService;

    // POST a client
    @PostMapping("/client")
    public void addClients(@RequestBody ClientsDto clientsDto){
        clientsService.addClients(clientsDto);
    }

    // DELETE a client by client id
    @DeleteMapping("/{clientId}")
    public void deleteClientsById(@PathVariable Long clientId){
        clientsService.deleteClientsById(clientId);
    }

    // PUT/ update client by client id
    @PutMapping
    public void updateClients(@RequestBody ClientsDto clientsDto){
        clientsService.updateClientsById(clientsDto);
    }

    // GET all clients
    @GetMapping("/client")
    public List<ClientsDto> getClients(){
        return clientsService.getAllClients();
    }

    // GET client by client id
    @GetMapping("/{clientId}")
    public Optional<ClientsDto> getClientsById(@PathVariable Long clientId){
        return clientsService.getClientsById(clientId);
    }


}
