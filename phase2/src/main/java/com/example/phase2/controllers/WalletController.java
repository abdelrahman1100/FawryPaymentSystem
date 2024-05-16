package com.example.phase2.controllers;

import com.example.phase2.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WalletController {
    @Autowired
    ClientService clientService;
    @PostMapping("/api/client/{clientId}/add to wallet/{amount}")
    ResponseEntity<String>addToWallet(@PathVariable int clientId,@PathVariable double amount){
        clientService.addToWallet(clientId,amount);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }
}
