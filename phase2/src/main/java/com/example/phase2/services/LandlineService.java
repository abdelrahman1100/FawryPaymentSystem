package com.example.phase2.services;

import com.example.phase2.models.Transaction;
import com.example.phase2.models.serviceproviders.Landline;
import com.example.phase2.models.user.Client;
import com.example.phase2.repositories.LandlineRepository;
import com.example.phase2.services.ClientService;
import com.example.phase2.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LandlineService {
    private LandlineRepository landlineRepository;
    LandlineService(LandlineRepository landlineRepository){
        this.landlineRepository=landlineRepository;
    }
    void save(Landline landline){
        landlineRepository.save(landline);
    }
    Landline findByPlan(String plan){
       return landlineRepository.findByPlan(plan);
    }
    void addMoney(String plan, double amount){
        Landline landline=landlineRepository.findByPlan(plan);
        landline.setAmount(landline.getAmount()+amount);
        landlineRepository.save(landline);
    }
    void withdrawMoney(String plan, double amount){
        Landline landline=landlineRepository.findByPlan(plan);
        landline.setAmount(landline.getAmount()-amount);
        landlineRepository.save(landline);
    }
}