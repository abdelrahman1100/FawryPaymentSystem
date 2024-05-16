package com.example.phase2.services.mobileservices;

import com.example.phase2.models.serviceproviders.DonationProvider;
import com.example.phase2.models.serviceproviders.MobileProvider;
import com.example.phase2.repositories.MobileProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MobileProviderService {
    @Autowired
    MobileProviderRepository mobileProviderRepository;

    public void createProvider(MobileProvider mobileProvider) {
        mobileProviderRepository.save(mobileProvider);
    }

    void addMoney(String provider, double amount) {
        MobileProvider mobileProvider = mobileProviderRepository.findByProviderName(provider);
        mobileProvider.addMoney(amount);
    }

    public MobileProvider findByProvider(String provider) {
        return mobileProviderRepository.findByProviderName(provider);
    }
}