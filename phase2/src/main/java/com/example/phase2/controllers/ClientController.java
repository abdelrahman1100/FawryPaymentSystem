package com.example.phase2.controllers;

import com.example.phase2.models.user.Client;
import com.example.phase2.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {
    @Autowired
    ClientService clientService;
    @PostMapping("/api/client/login")
    public ResponseEntity<String>loginUser(@RequestBody Client client){
       Boolean flag= clientService.login(client);
       if(flag){
           return new ResponseEntity<>("success", HttpStatus.OK);
       }
       else{
           return new ResponseEntity<>("invalid username or password", HttpStatus.BAD_REQUEST);
       }

    }
    @PostMapping("/api/client/signup")
    public ResponseEntity<String>signUpUSer(@RequestBody Client client){
        if(clientService.existByName(client.getName())){
            return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
        }
        else{
            clientService.signUp(client);
            return new ResponseEntity<>("success", HttpStatus.CREATED);
        }
    }

    @GetMapping("/api/client/{userName}")
    public ResponseEntity<Client>findUserByName(@PathVariable String userName){
        Client client=clientService.findByName(userName);
        return new ResponseEntity<>(client,HttpStatus.OK);
    }
    @GetMapping("/api/client")
    public ResponseEntity<List<Client>>loginUser(){
        List<Client> list=clientService.findAll();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
}
