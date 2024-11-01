package com.example.phase2.controllers;

import com.example.phase2.models.user.Client;
import com.example.phase2.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
class ClientController {
    ClientService clientService;
    @Autowired
    public ClientController(ClientService clientService){
        this.clientService=clientService;
    }
    @PostMapping("/clients")
    public Client save(@RequestBody Client client){
        return clientService.save(client);
    }

    @GetMapping("/clients/{userName}")
    public Client findUserByName(@PathVariable String userName){
        Client client=clientService.findByName(userName);
        return client;
    }
    @GetMapping("/clients")
    public List<Client>findAll(){
        List<Client> list=clientService.findAll();
        return list;
    }
    @PostMapping("/wallet/add/{clientId}/{amount}")
    ResponseEntity<String>addWallet(@PathVariable Long clientId,@PathVariable double amount){
        try {
            clientService.addWallet(clientId, amount);
            return ResponseEntity.ok("Money added successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to add money to wallet.");
        }
    }
}
