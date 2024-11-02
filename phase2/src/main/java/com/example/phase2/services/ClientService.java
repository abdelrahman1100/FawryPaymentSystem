package com.example.phase2.services;

import com.example.phase2.models.user.Client;
import com.example.phase2.models.user.CreditCard;
import com.example.phase2.repositories.ClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    //?? repo or service
    ClientRepository clientRepository;
    CreditCardService creditCardService;
    @Autowired
    ClientService(ClientRepository clientRepository,CreditCardService creditCardService){
        this.clientRepository=clientRepository;
        this.creditCardService=creditCardService;
    }
    @Transactional
    public Client save(Client client){
       Client dbClient= clientRepository.save(client);
        return dbClient;
    }
    public Client findByName(String name){
        return clientRepository.findByName(name);
    }
    public List<Client> findAll(){
        return clientRepository.findAll();
    }
    public Client findById(Long id){
        Optional<Client> result=clientRepository.findById(id);
        Client client=null;
        if(result.isPresent()){
            client=result.get();
        }
        else{
            throw new RuntimeException("Did not find client id - "+id);
        }
       return client;
    }
    @Transactional
    public void delete(Long id){
        clientRepository.deleteById(id);
    }

    public Boolean existByName(String name){
        return clientRepository.existsByName(name);
    }
    @Transactional
    public void addWallet(Long id, double amount) {
        Optional<Client> result=clientRepository.findById(id);
        Client client=null;
        if(result.isPresent()){
            client=result.get();
        }
        else{
            throw new RuntimeException("Did not find client id - "+id);
        }
        client.setWallet(client.getWallet()+amount);
        clientRepository.save(client);
    }
    @Transactional
    public void withdrawWallet(Long id, double amount) {
        Optional<Client> result=clientRepository.findById(id);
        Client client=null;
        if(result.isPresent()){
            client=result.get();
        }
        else{
            throw new RuntimeException("Did not find client id - "+id);
        }
        client.setWallet(client.getWallet()-amount);
        clientRepository.save(client);
    }
    @Transactional
    public void addCreditCard(Long id, double amount){
        Optional<Client> result=clientRepository.findById(id);
        Client client=null;
        if(result.isPresent()){
            client=result.get();
        }
        else{
            throw new RuntimeException("Did not find client id - "+id);
        }
        CreditCard creditCard=client.getCreditCard();
        creditCardService.addAmount(creditCard.getCardNumber(),amount);
    }
    @Transactional
    public void withdrawCreditCard(Long id, double amount) {
        Optional<Client> result=clientRepository.findById(id);
        Client client=null;
        if(result.isPresent()){
            client=result.get();
        }
        else{
            throw new RuntimeException("Did not find client id - "+id);
        }
        CreditCard creditCard=client.getCreditCard();
        creditCardService.withdrawAmount(creditCard.getCardNumber(),amount);
    }
}
