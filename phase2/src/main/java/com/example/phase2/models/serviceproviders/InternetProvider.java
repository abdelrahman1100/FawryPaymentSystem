package com.example.phase2.models.serviceproviders;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class InternetProvider {
    @Id
    Long id;
    String providerName;
    double amount;

    public InternetProvider() {

    }

    public void addMoney(double amount){
        this.amount+=amount;
    }

    public InternetProvider(String providerName) {
        this.providerName = providerName;
        this.amount=0;
    }

    public double getMoney(double requiredAmount) {
        this.amount-=requiredAmount;
        return requiredAmount;
    }
}
