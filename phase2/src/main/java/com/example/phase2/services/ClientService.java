package com.example.phase2.services;

import com.example.phase2.models.user.Client;
import com.example.phase2.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;
    public Boolean login(Client client){
        if(clientRepository.existsByName(client.getName())){
            Client client1=clientRepository.findByName(client.getName());
            if(client.getPassword()==client1.getPassword()){
                client1.setAvailable(true);
                return true;
            }
        }
        return false;
    }
    //check
    public void signUp(Client client){
        clientRepository.save(client);
    }
    public Client findByName(String name){
        return clientRepository.findByName(name);
    }
    public Boolean existByName(String name){
        return clientRepository.existsByName(name);
    }
    public List<Client> findAll(){
        return clientRepository.findAll();
    }
    public Client findById(int id){
       return clientRepository.findById(id).get();
    }

    public void addToWallet(int clientId, double amount) {
        Client client=clientRepository.findById(clientId).get();
        client.setWallet(client.getWallet()+amount);
    }
}
