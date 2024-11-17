package com.example.phase2.models;

import com.example.phase2.models.Client;
import jakarta.persistence.*;

@Entity
@Table(name="credit_card")
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long creditCardId;
    String cardNumber;
    String cardPassword;
    double amount;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
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

    public void setClient(Client client) {
        this.client = client;
    }
}