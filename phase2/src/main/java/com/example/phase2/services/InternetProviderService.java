package com.example.phase2.services;

import com.example.phase2.models.serviceproviders.DonationProvider;
import com.example.phase2.models.serviceproviders.InternetProvider;
import com.example.phase2.models.serviceproviders.MobileProvider;
import com.example.phase2.repositories.InternetProviderRepository;
import com.example.phase2.repositories.MobileProviderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InternetProviderService {
    InternetProviderRepository internetProviderRepository;
    @Autowired
    InternetProviderService(InternetProviderRepository internetProviderRepository){
        this.internetProviderRepository=internetProviderRepository;
    }
    @Transactional
    public void createProvider(InternetProvider internetProvider) {
        internetProviderRepository.save(internetProvider);
    }
    @Transactional
    void addMoney(String provider, double amount) {
        InternetProvider internetProvider = internetProviderRepository.findByProviderName(provider);
        internetProvider.setAmount(internetProvider.getAmount()+amount);
        internetProviderRepository.save(internetProvider);
    }
    @Transactional
    void withdrawMoney(String provider, double amount) {
        InternetProvider internetProvider = internetProviderRepository.findByProviderName(provider);
        internetProvider.setAmount(internetProvider.getAmount()-amount);
        internetProviderRepository.save(internetProvider);
    }

    public InternetProvider findByProvider(String provider) {
        return internetProviderRepository.findByProviderName(provider);
    }
}