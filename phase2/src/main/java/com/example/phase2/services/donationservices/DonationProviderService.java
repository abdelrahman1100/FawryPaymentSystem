package com.example.phase2.services.donationservices;

import com.example.phase2.models.serviceproviders.DonationProvider;
import com.example.phase2.models.serviceproviders.InternetProvider;
import com.example.phase2.repositories.DonationProviderRepository;
import com.example.phase2.repositories.InternetProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DonationProviderService {
    @Autowired
    DonationProviderRepository donationProviderRepository;

    public void createProvider(DonationProvider donationProvider) {
        donationProviderRepository.save(donationProvider);
    }

    void addMoney(String provider, double amount) {
        DonationProvider donationProvider = donationProviderRepository.findByProviderName(provider);
        donationProvider.addMoney(amount);
    }

    public DonationProvider findByProvider(String provider) {
        return donationProviderRepository.findByProviderName(provider);
    }
}