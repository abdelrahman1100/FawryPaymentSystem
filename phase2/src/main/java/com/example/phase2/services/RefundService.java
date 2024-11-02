package com.example.phase2.services;

import com.example.phase2.models.Refund;
import com.example.phase2.models.Transaction;
import com.example.phase2.models.serviceproviders.DonationProvider;
import com.example.phase2.models.serviceproviders.InternetProvider;
import com.example.phase2.models.serviceproviders.Landline;
import com.example.phase2.models.serviceproviders.MobileProvider;
import com.example.phase2.models.user.Client;
import com.example.phase2.repositories.RefundRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RefundService {
    ClientService clientService;
    DonationProviderService donationProviderService;
    MobileProviderService mobileProviderService;
    LandlineService landlineService;
    InternetProviderService internetProviderService;
    @Autowired
    public RefundService(ClientService clientService){
        this.clientService=clientService;
    }
    @Transactional
    public void save(Refund refund){
        Transaction transaction=refund.getTransaction();
        double amount=transaction.getAmount();
        if(transaction.getDonationProvider()!=null){
            donationProviderService.withdrawMoney(transaction.getDonationProvider().getProviderName(),amount);
        }
        else if(transaction.getLandline()!=null){
            landlineService.withdrawMoney(transaction.getLandline().getPlan(),amount);
        }
        else if(transaction.getMobileProvider()!=null){
            mobileProviderService.withdrawMoney(transaction.getMobileProvider().getProviderName(),amount);
        }
        else if(transaction.getInternetProvider()!=null) {
            internetProviderService.withdrawMoney(transaction.getInternetProvider().getProviderName(),amount);
        }
        Client client=transaction.getClient();
        clientService.addCreditCard(client.getId(),amount);
    }
}
