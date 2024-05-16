package com.example.phase2.services.donationservices;

import com.example.phase2.models.Transaction;
import com.example.phase2.models.user.Client;
import com.example.phase2.services.ClientService;
import com.example.phase2.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DonationService {
    @Autowired
    DonationProviderService donationProviderService;
    @Autowired
    TransactionService transactionService;
    @Autowired
    ClientService clientService;

    public void makeTransaction(int clientId, String provider, String paymentMethod, double amount) {
        Client client = clientService.findById(clientId);
        if (paymentMethod.equals("credit card")) {
            donationProviderService.addMoney(provider, amount);
            transactionService.createTransaction(new Transaction("donation", clientId, provider, paymentMethod, amount));
            client.getCreditCard().setAmount(client.getCreditCard().getAmount() - amount);
        } else if (paymentMethod.equals("wallet")) {
            donationProviderService.addMoney(provider, amount);
            transactionService.createTransaction(new Transaction("donation", clientId, provider, paymentMethod, amount));
            client.setWallet((client.getWallet() - amount));
        }
    }
}