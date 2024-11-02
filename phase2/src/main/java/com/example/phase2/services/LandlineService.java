package com.example.phase2.services;

import com.example.phase2.models.Transaction;
import com.example.phase2.models.serviceproviders.Landline;
import com.example.phase2.models.user.Client;
import com.example.phase2.repositories.LandlineRepository;
import com.example.phase2.services.ClientService;
import com.example.phase2.services.TransactionService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LandlineService {
    LandlineRepository landlineRepository;
    LandlineService(LandlineRepository landlineRepository){
        this.landlineRepository=landlineRepository;
    }
    @Transactional
    void save(Landline landline){
        landlineRepository.save(landline);
    }
    Landline findByPlan(String plan){
       return landlineRepository.findByPlan(plan);
    }
    @Transactional
    void addMoney(String plan, double amount){
        Landline landline=landlineRepository.findByPlan(plan);
        landline.setAmount(landline.getAmount()+amount);
        landlineRepository.save(landline);
    }
    @Transactional
    void withdrawMoney(String plan, double amount){
        Landline landline=landlineRepository.findByPlan(plan);
        landline.setAmount(landline.getAmount()-amount);
        landlineRepository.save(landline);
    }
}