package com.example.phase2.models.serviceproviders;

import com.example.phase2.models.Transaction;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="mobile_provider")
public class MobileProvider {
    @Id
    @Column(name="id")
    Long id;
    @Column(name="provider_name")
    String providerName;
    @Column(name="amount")
    double amount;
    @Column(name="price")
    double price;
    @JoinColumn
    @OneToMany
    List<Transaction> transactions;

    public MobileProvider() {
    }
    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
