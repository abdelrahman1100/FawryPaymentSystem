package com.example.phase2.services.mobileservices;

import com.example.phase2.models.Transaction;
import com.example.phase2.models.user.Client;
import com.example.phase2.services.ClientService;
import com.example.phase2.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//fix client id to long
@Service
public class MobileRechargeService {
    @Autowired
    MobileProviderService mobileProviderService ;
    @Autowired
    TransactionService transactionService;
    @Autowired
    ClientService clientService;
    public void makeTransaction(int clientId, String provider, String paymentMethod, double amount){
        Client client=clientService.findById(clientId);
        if(paymentMethod.equals("credit card")){
            mobileProviderService.addMoney(provider,amount);
            transactionService.createTransaction(new Transaction("mobile recharge",clientId,provider,paymentMethod,amount));
            client.getCreditCard().setAmount(client.getCreditCard().getAmount()-amount);
        }
        else if(paymentMethod.equals("wallet")){
            mobileProviderService.addMoney(provider,amount);
            transactionService.createTransaction(new Transaction("mobile recharge",clientId,provider,paymentMethod,amount));
            client.setWallet((client.getWallet()-amount));
        }
    }
}
