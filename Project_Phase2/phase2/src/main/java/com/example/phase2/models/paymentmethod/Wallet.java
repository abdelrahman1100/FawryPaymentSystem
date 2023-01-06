package com.example.phase2.models.paymentmethod;

import com.example.phase2.models.paymentmethod.Payment;

public class Wallet extends Payment {
    public double getAmount(){
        return this.amount;
    }
    public Wallet(){
        this.amount=300;
    }
}
