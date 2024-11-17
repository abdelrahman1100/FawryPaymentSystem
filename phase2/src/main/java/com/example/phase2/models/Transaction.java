package com.example.phase2.models;

import com.example.phase2.models.serviceproviders.*;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;
    double amount;
    private LocalDateTime transactionDate;
    @ManyToOne
    @JoinColumn(name = "client_id",nullable = false)
    Client client;
    @ManyToOne
    @JoinColumn(name = "service_provider_id",nullable = false)
    ServiceProvider serviceProvider;

    private String paymentMethod;
    public Transaction() {
    }

    public Transaction(Client client, ServiceProvider serviceProvider,double amount,String paymentMethod) {
        this.amount = amount;
        this.client = client;
        this.serviceProvider = serviceProvider;
        this.paymentMethod=paymentMethod;
        this.transactionDate= LocalDateTime.now();
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }


    public void setClient(Client client) {
        this.client = client;
    }


    public void setServiceProvider(ServiceProvider serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
