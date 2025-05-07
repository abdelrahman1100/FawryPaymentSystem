package com.example.phase2.repositories;

import com.example.phase2.models.serviceproviders.ServiceProvider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceProviderRepository extends JpaRepository<ServiceProvider,Long> {
}
