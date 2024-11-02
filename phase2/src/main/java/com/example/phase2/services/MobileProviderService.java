package com.example.phase2.services;

import com.example.phase2.models.serviceproviders.DonationProvider;
import com.example.phase2.models.serviceproviders.MobileProvider;
import com.example.phase2.repositories.MobileProviderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MobileProviderService {
    MobileProviderRepository mobileProviderRepository;
    @Autowired
    MobileProviderService(MobileProviderRepository mobileProviderRepository){
        this.mobileProviderRepository=mobileProviderRepository;
    }
    @Transactional
    public void createProvider(MobileProvider mobileProvider) {
        mobileProviderRepository.save(mobileProvider);
    }
    @Transactional
    void addMoney(String provider, double amount) {
        MobileProvider mobileProvider = mobileProviderRepository.findByProviderName(provider);
        mobileProvider.setAmount(mobileProvider.getAmount()+amount);
        mobileProviderRepository.save(mobileProvider);
    }
    @Transactional
    void withdrawMoney(String provider, double amount) {
        MobileProvider mobileProvider = mobileProviderRepository.findByProviderName(provider);
        mobileProvider.setAmount(mobileProvider.getAmount()-amount);
        mobileProviderRepository.save(mobileProvider);
    }
    public MobileProvider findByProvider(String provider) {
        return mobileProviderRepository.findByProviderName(provider);
    }
}