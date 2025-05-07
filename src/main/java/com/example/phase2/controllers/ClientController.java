package com.example.phase2.controllers;

import com.example.phase2.models.Client;
import com.example.phase2.models.CreditCard;
import com.example.phase2.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
class ClientController {
    ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService){
        this.clientService=clientService;
    }

    @PostMapping
    public Client createClient(@RequestBody Client client){
        return clientService.save(client);
    }

    @GetMapping("/{clientId}")
    public Client findClientById(@PathVariable Long clientId){
        return clientService.findById(clientId);
    }

    @GetMapping
    public List<Client>findAll(){
        return clientService.findAll();
    }

    @PostMapping("/{clientId}/credit-card")
    public CreditCard addCreditCardToClient(@PathVariable Long clientId,@RequestBody CreditCard creditCard){
        return clientService.addCreditCardToClient(clientId,creditCard);
    }
}