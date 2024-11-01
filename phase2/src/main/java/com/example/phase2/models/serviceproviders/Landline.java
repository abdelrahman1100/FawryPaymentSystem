package com.example.phase2.models.serviceproviders;

import com.example.phase2.models.Transaction;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="landline")
public class Landline {
    @Id
    @Column(name="id")
    Long id;
    @Column(name="amount")
    double amount;
    @Column(name="plan")
    String plan;
    @Column(name="price")
    double price;

    @JoinColumn
    @OneToMany
    List<Transaction> transactions;
    public Landline(){
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public double getAmount() {
        return amount;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
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
