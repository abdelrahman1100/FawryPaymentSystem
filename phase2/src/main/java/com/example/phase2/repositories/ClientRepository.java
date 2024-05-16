package com.example.phase2.repositories;

import com.example.phase2.models.user.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    boolean existsByName(String name);

    boolean exists(Client client);
    Client findByName(String name);
}
