package com.example.phase2.services.landlineservices;

import com.example.phase2.models.Transaction;
import com.example.phase2.models.serviceproviders.Landline;
import com.example.phase2.models.user.Client;
import com.example.phase2.services.ClientService;
import com.example.phase2.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LandlineService {
    @Autowired
    Landline landline;
    @Autowired
    TransactionService transactionService;
    @Autowired
    ClientService clientService;
    public void makeTransaction(int clientId, String plan, String paymentMethod, double amount){
        double requiredAmount= landline.getPlanFees(plan);
        Client client=clientService.findById(clientId);
        if(paymentMethod.equals("credit card")){
            if(client.getCreditCard().getAmount()>=requiredAmount) {
                landline.setAmount(landline.getAmount()+amount);
                transactionService.createTransaction(new Transaction("landline", clientId, plan, paymentMethod, amount));
                client.getCreditCard().setAmount(client.getCreditCard().getAmount() - amount);
            }
            else{

            }
        }
        else if(paymentMethod.equals("wallet")){
            if(client.getWallet()>=requiredAmount) {
                landline.setAmount(landline.getAmount()+amount);
                transactionService.createTransaction(new Transaction("landline", clientId, plan, paymentMethod,amount));
                client.setWallet((client.getWallet()-amount));
            }
            else{

            }
        }
    }
}