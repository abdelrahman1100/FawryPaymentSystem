package com.example.phase2.models.serviceproviders;

import com.example.phase2.models.Transaction;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="donation_provider")
public class DonationProvider {
    @Id
    @Column(name="id")
    Long id;
    @Column(name="provider_name")
    String providerName;
    @Column(name="amount")
    double amount;
    //??
    @JoinColumn
    @OneToMany
    List<Transaction>transactions;

    public DonationProvider() {
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

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
