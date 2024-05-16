package com.example.phase2.repositories;

import com.example.phase2.models.Refund;
import com.example.phase2.models.serviceproviders.MobileProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefundRepository extends JpaRepository<Refund,Long> {
}
