package com.example.phase2.models.serviceproviders;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class MobileProvider {
    @Id
    Long id;
    String providerName;
    double amount;


    public MobileProvider() {

    }
    public MobileProvider(String providerName) {
        this.providerName = providerName;
        this.amount=0;
    }

    public void addMoney(double amount){
        this.amount+=amount;
    }



    public double getMoney(double requiredAmount) {
        this.amount-=requiredAmount;
        return requiredAmount;
    }
}
