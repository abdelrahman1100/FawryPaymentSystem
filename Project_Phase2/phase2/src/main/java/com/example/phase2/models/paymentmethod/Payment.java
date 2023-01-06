package com.example.phase2.models.paymentmethod;

import com.example.phase2.models.user.Client;

public abstract class Payment {
    int clientId;
    double amount;
    public double getAmount(){
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
