package com.example.phase2.models.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CreditCard {
    @Id
    String cardNumber;
    String cardPassword;
    double amount;

    public CreditCard() {

    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setCardPassword(String cardPassword) {
        this.cardPassword = cardPassword;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardPassword() {
        return cardPassword;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public CreditCard(String cardNumber, String cardPassword, double amount) {
        this.cardNumber = cardNumber;
        this.cardPassword = cardPassword;
        this.amount = amount;
    }
}