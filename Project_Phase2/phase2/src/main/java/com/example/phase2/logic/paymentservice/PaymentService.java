package com.example.phase2.logic.paymentservice;

import com.example.phase2.models.Providers.ServiceProvider;
import com.example.phase2.models.Services.Service;

public class PaymentService {
    public double pay(Service service){
        double cost=service.getCost();
        return cost;
    }
}
