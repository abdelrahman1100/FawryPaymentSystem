package com.example.phase2.services;

import com.example.phase2.models.serviceproviders.DonationProvider;
import com.example.phase2.models.serviceproviders.InternetProvider;
import com.example.phase2.repositories.DonationProviderRepository;
import com.example.phase2.repositories.InternetProviderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DonationProviderService {
    DonationProviderRepository donationProviderRepository;
    @Autowired
    DonationProviderService(DonationProviderRepository donationProviderRepository){
        this.donationProviderRepository=donationProviderRepository;
    }
    @Transactional
    public void createProvider(DonationProvider donationProvider) {
        donationProviderRepository.save(donationProvider);
    }
    @Transactional
    void addMoney(String provider, double amount) {
        DonationProvider donationProvider = donationProviderRepository.findByProviderName(provider);
        donationProvider.setAmount(donationProvider.getAmount()+amount);
        donationProviderRepository.save(donationProvider);
    }
    @Transactional
    void withdrawMoney(String provider, double amount) {
        DonationProvider donationProvider = donationProviderRepository.findByProviderName(provider);
        donationProvider.setAmount(donationProvider.getAmount()-amount);
        donationProviderRepository.save(donationProvider);
    }
    @Transactional
    public DonationProvider findByProvider(String provider) {
        return donationProviderRepository.findByProviderName(provider);
    }
}