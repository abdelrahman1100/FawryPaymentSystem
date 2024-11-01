package com.example.phase2.models.user;

import jakarta.persistence.*;

@Entity
@Table(name="credit_card")
public class CreditCard {
    @Id
    @Column(name="card_number")
    String cardNumber;
    @Column(name="card_password")
    String cardPassword;
    @Column(name = "amount")
    double amount;
    @JoinColumn
    @OneToOne
    Client client;
    public CreditCard() {
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardPassword() {
        return cardPassword;
    }

    public void setCardPassword(String cardPassword) {
        this.cardPassword = cardPassword;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}