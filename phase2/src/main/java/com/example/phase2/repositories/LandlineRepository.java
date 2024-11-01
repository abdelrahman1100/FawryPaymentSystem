package com.example.phase2.repositories;

import com.example.phase2.models.serviceproviders.Landline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LandlineRepository extends JpaRepository<Landline,Long> {
    Landline findByPlan(String plan);
}
