package com.example.phase2.repositories;

import com.example.phase2.models.serviceproviders.InternetProvider;
import com.example.phase2.models.serviceproviders.MobileProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InternetProviderRepository extends JpaRepository<InternetProvider,Long> {
    InternetProvider findByProviderName(String providerName);

}
