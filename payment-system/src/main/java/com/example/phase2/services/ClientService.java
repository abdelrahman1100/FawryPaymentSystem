package com.example.phase2.services;

import com.example.phase2.models.Client;
import com.example.phase2.models.CreditCard;
import com.example.phase2.repositories.ClientRepository;
import com.example.phase2.repositories.CreditCardRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    ClientRepository clientRepository;
    CreditCardRepository creditCardRepository;
    @Autowired
    ClientService(ClientRepository clientRepository,CreditCardRepository creditCardRepository){
        this.clientRepository=clientRepository;
        this.creditCardRepository=creditCardRepository;
    }

    @Transactional
    public Client save(Client client){
       Client dbClient= clientRepository.save(client);
        return dbClient;
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

    @Transactional
    public CreditCard addCreditCardToClient(long clientId, CreditCard creditCard){
        Optional<Client> result=clientRepository.findById(clientId);
        Client client=null;
        if(result.isPresent()){
            client=result.get();
        }
        else{
            throw new RuntimeException("Did not find client id - "+clientId);
        }
        creditCard.setClient(client);
        return creditCardRepository.save(creditCard);
    }

}
