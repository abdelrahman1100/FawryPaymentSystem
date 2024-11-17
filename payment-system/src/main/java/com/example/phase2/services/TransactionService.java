package com.example.phase2.services;

import com.example.phase2.dto.PaymentRequest;
import com.example.phase2.models.Transaction;
import com.example.phase2.models.serviceproviders.ServiceProvider;
import com.example.phase2.models.Client;
import com.example.phase2.repositories.ClientRepository;
import com.example.phase2.repositories.ServiceProviderRepository;
import com.example.phase2.repositories.TransactionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    TransactionRepository transactionRepository;
    ClientRepository clientRepository;
    ServiceProviderRepository serviceProviderRepository;
    @Autowired
    TransactionService(TransactionRepository transactionRepository,ClientRepository clientRepository,ServiceProviderRepository serviceProviderRepository){
        this.transactionRepository=transactionRepository;
        this.clientRepository=clientRepository;
        this.serviceProviderRepository=serviceProviderRepository;
    }
    @Transactional
    public Transaction createTransaction(PaymentRequest paymentRequest){
        Long clientId = paymentRequest.getClientId();
        Long serviceProviderId = paymentRequest.getProviderId();
        double amount = paymentRequest.getAmount();
        String paymentMethod= paymentRequest.getPaymentMethod().toUpperCase();


        Optional<Client> clientResult=clientRepository.findById(clientId);
        Client client=null;
        if(clientResult.isPresent()){
            client=clientResult.get();
        }
        else{
            throw new RuntimeException("Did not find client id - "+paymentRequest.getClientId());
        }

        Optional<ServiceProvider>serviceProviderResult=serviceProviderRepository.findById(serviceProviderId);
        ServiceProvider serviceProvider=null;
        if(serviceProviderResult.isPresent()){
            serviceProvider=serviceProviderResult.get();
        }
        else{
            throw new RuntimeException("Did not find service provider id - "+paymentRequest.getProviderId());
        }
        if (!serviceProvider.isAmountSufficient(amount)) {
            throw new RuntimeException("Insufficient amount for service fee.");
        }


        switch (paymentMethod) {
            case "WALLET" -> {
                if (!client.hasSufficientBalance(amount)) {
                    throw new RuntimeException("Insufficient wallet balance.");
                }
                client.deductBalance(amount);
            }
            case "CREDIT_CARD" -> {
                if (client.getCreditCard().getAmount() < amount) {
                    throw new RuntimeException("Insufficient credit card limit.");
                }
                client.getCreditCard().setAmount(client.getCreditCard().getAmount() - amount);
            }
            default -> throw new RuntimeException("Invalid payment method.");
        }


        Transaction transaction=new Transaction(client,serviceProvider,amount,paymentMethod);
        transactionRepository.save(transaction);

        client.addTransaction(transaction);
        clientRepository.save(client);

        serviceProvider.addTransaction(transaction);
        serviceProviderRepository.save(serviceProvider);

        return transaction;
    }

    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    public Transaction findByID(Long id) {
        Optional<Transaction>result=transactionRepository.findById(id);
        Transaction transaction=null;
        if(result.isPresent()){
             transaction=result.get();
        }
        else{
            throw new RuntimeException("Did not find transaction id - "+id);
        }
        return transaction;
    }
}
   