package com.example.phase2.services.internetservices;

import com.example.phase2.models.serviceproviders.DonationProvider;
import com.example.phase2.models.serviceproviders.InternetProvider;
import com.example.phase2.models.serviceproviders.MobileProvider;
import com.example.phase2.repositories.InternetProviderRepository;
import com.example.phase2.repositories.MobileProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InternetProviderService {
    @Autowired
    InternetProviderRepository internetProviderRepository;

    public void createProvider(InternetProvider internetProvider) {
        internetProviderRepository.save(internetProvider);
    }

    void addMoney(String provider, double amount) {
        InternetProvider internetProvider = internetProviderRepository.findByProviderName(provider);
        internetProvider.addMoney(amount);
    }

    public InternetProvider findByProvider(String provider) {
        return internetProviderRepository.findByProviderName(provider);
    }
}