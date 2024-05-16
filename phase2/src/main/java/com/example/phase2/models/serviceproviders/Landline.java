package com.example.phase2.models.serviceproviders;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class Landline {
    double amount;
   public double getPlanFees(String plan){
        if(plan=="Monthly receipt"){
            return 80;
        }
        else if(plan=="Quarter receipt"){
            return 100;
        }
        return 0;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public double getMoney(double requiredAmount){
       this.amount-=requiredAmount;
       return requiredAmount;
    }
}
