package com.example.phase2.repositories;

import com.example.phase2.models.serviceproviders.MobileProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MobileProviderRepository extends JpaRepository<MobileProvider,Long> {
    MobileProvider findByProviderName(String providerName);
}
