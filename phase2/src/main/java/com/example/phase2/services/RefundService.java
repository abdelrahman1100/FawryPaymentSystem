package com.example.phase2.services;

import com.example.phase2.models.Refund;
import com.example.phase2.models.Transaction;
import com.example.phase2.models.serviceproviders.DonationProvider;
import com.example.phase2.models.serviceproviders.InternetProvider;
import com.example.phase2.models.serviceproviders.Landline;
import com.example.phase2.models.serviceproviders.MobileProvider;
import com.example.phase2.models.user.Client;
import com.example.phase2.repositories.RefundRepository;
import com.example.phase2.services.donationservices.DonationProviderService;
import com.example.phase2.services.internetservices.InternetProviderService;
import com.example.phase2.services.mobileservices.MobileProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RefundService {
    @Autowired
    RefundRepository refundRepository;
    @Autowired
    TransactionService transactionService;
    @Autowired
    ClientService clientService;
    @Autowired
    MobileProviderService mobileProviderService;
    @Autowired
    InternetProviderService internetProviderService;
    @Autowired
    Landline landline;
    @Autowired
    DonationProviderService donationProviderService;
    public void makeRefundRequest(int clientId, Long transactionId) {
        Transaction transaction=transactionService.findByID(transactionId);
        Client client=clientService.findById(clientId);

        String serviceType=transaction.getServiceType();
        if(serviceType=="mobile recharge"){
            String provider= transaction.getProvider();
            MobileProvider mobileProvider= mobileProviderService.findByProvider(provider);
            double amount = mobileProvider.getMoney(transaction.getAmount());
            client.setWallet(client.getWallet()+transaction.getAmount());
        }
        else if(serviceType=="internet payment"){
            String provider= transaction.getProvider();
            InternetProvider internetProvider= internetProviderService.findByProvider(provider);
            double amount = internetProvider.getMoney(transaction.getAmount());
            client.setWallet(client.getWallet()+amount);
        }
        else if(serviceType=="landline"){
            double amount=landline.getMoney(transaction.getAmount());
            client.setWallet(client.getWallet()+amount);
        }
        else if(serviceType=="donation"){
            String provider= transaction.getProvider();
            DonationProvider donationProvider= donationProviderService.findByProvider(provider);
            double amount = donationProvider.getMoney(transaction.getAmount());
            client.setWallet(client.getWallet()+amount);
        }
        refundRepository.save(new Refund(clientId,transactionId));
    }
}
