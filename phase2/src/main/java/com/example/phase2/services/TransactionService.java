package com.example.phase2.services;

import com.example.phase2.models.Transaction;
import com.example.phase2.models.user.Client;
import com.example.phase2.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    TransactionRepository transactionRepository;
    DonationProviderService donationProviderService;
    LandlineService landlineService;
    MobileProviderService mobileProviderService;
    InternetProviderService internetProviderService;
    ClientService clientService;
    @Autowired
    TransactionService(TransactionRepository transactionRepository,DonationProviderService donationProviderService,LandlineService landlineService,MobileProviderService mobileProviderService,InternetProviderService internetProviderService,ClientService clientService){
        this.transactionRepository=transactionRepository;
        this.donationProviderService=donationProviderService;
        this.landlineService=landlineService;
        this.mobileProviderService=mobileProviderService;
        this.internetProviderService=internetProviderService;
        this.clientService=clientService;
    }

    public void save(Transaction transaction) {
        if(transaction.getDonationProvider()!=null){
            String providerName=transaction.getDonationProvider().getProviderName();
            double amount=transaction.getAmount();
            Client client=transaction.getClient();
            if(transaction.getPaymentMethod().equals("Wallet")){
                if(client.getWallet()>=amount){
                    clientService.withdrawWallet(client.getId(),amount);
                }
                else{
                    throw new RuntimeException("Wallet amount less than required amount");
                }
            }
            else{
                if(client.getCreditCard().getAmount()>=amount){
                    clientService.withdrawCreditCard(client.getId(),amount);
                }
                else{
                    throw new RuntimeException("Wallet amount less than required amount");
                }
            }
            donationProviderService.addMoney(providerName,amount);
            transactionRepository.save(transaction);
        }
        else if(transaction.getLandline()!=null){
            String providerName=transaction.getLandline().getPlan();
            double amount=transaction.getAmount();
            double price=transaction.getLandline().getPrice();
            Client client=transaction.getClient();
            if(amount<price){
                throw new RuntimeException("added amount less than service price");
            }
            if(transaction.getPaymentMethod().equals("Wallet")){
                if(client.getWallet()>=amount){
                    clientService.withdrawWallet(client.getId(),amount);
                }
                else{
                    throw new RuntimeException("Wallet amount less than required amount");
                }
            }
            else{
                if(client.getCreditCard().getAmount()>=amount){
                    clientService.withdrawCreditCard(client.getId(),amount);
                }
                else{
                    throw new RuntimeException("Wallet amount less than required amount");
                }
            }
            landlineService.addMoney(providerName,amount);
            transactionRepository.save(transaction);
        }
        else if(transaction.getMobileProvider()!=null){
            String providerName=transaction.getMobileProvider().getProviderName();
            double amount=transaction.getAmount();
            double price=transaction.getMobileProvider().getPrice();
            Client client=transaction.getClient();
            if(amount<price){
                throw new RuntimeException("added amount less than service price");
            }
            if(transaction.getPaymentMethod().equals("Wallet")){
                if(client.getWallet()>=amount){
                    clientService.withdrawWallet(client.getId(),amount);
                }
                else{
                    throw new RuntimeException("Wallet amount less than required amount");
                }
            }
            else{
                if(client.getCreditCard().getAmount()>=amount){
                    clientService.withdrawCreditCard(client.getId(),amount);
                }
                else{
                    throw new RuntimeException("Wallet amount less than required amount");
                }
            }
            mobileProviderService.addMoney(providerName,amount);
            transactionRepository.save(transaction);
        }
        else if(transaction.getInternetProvider()!=null){
            String providerName=transaction.getInternetProvider().getProviderName();
            double amount=transaction.getAmount();
            double price=transaction.getInternetProvider().getPrice();
            Client client=transaction.getClient();
            if(amount<price){
                throw new RuntimeException("added amount less than service price");
            }
            if(transaction.getPaymentMethod().equals("Wallet")){
                if(client.getWallet()>=amount){
                    clientService.withdrawWallet(client.getId(),amount);
                }
                else{
                    throw new RuntimeException("Wallet amount less than required amount");
                }
            }
            else{
                if(client.getCreditCard().getAmount()>=amount){
                    clientService.withdrawCreditCard(client.getId(),amount);
                }
                else{
                    throw new RuntimeException("Wallet amount less than required amount");
                }
            }
            internetProviderService.addMoney(providerName,amount);
            transactionRepository.save(transaction);
        }
        else{
            throw new RuntimeException("service provider doesn't exist");
        }
    }

    List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    Transaction findByID(Long id) {
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
   