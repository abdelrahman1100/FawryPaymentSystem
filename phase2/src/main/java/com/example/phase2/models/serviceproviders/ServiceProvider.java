package com.example.phase2.models.serviceproviders;

import com.example.phase2.models.Transaction;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ServiceProvider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long providerId;
    private String providerName;
    private double price;
    private double totalAmount=0.0;

    @OneToMany(mappedBy = "serviceProvider")
    List<Transaction>transactions;
    public ServiceProvider() {}

    public ServiceProvider(String providerName, double price) {
        this.providerName = providerName;
        this.price = price;
        this.totalAmount=0.0;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        addToTotalAmount(transaction.getAmount());
    }

    public Long getProviderId() {
        return providerId;
    }

    public void setProviderId(Long providerId) {
        this.providerId = providerId;
    }

    public void addToTotalAmount(double amount) {
        this.totalAmount += amount;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public boolean isAmountSufficient(double amount) {
        return amount>=price;
    }
}
