package com.example.phase2.repositories;

import com.example.phase2.models.serviceproviders.DonationProvider;
import com.example.phase2.models.serviceproviders.InternetProvider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonationProviderRepository extends JpaRepository<DonationProvider,Long> {
    DonationProvider findByProviderName(String providerName);
}
