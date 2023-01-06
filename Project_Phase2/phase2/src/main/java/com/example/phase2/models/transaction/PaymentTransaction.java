package com.example.phase2.models.transaction;

import com.example.phase2.models.transaction.Transaction;

public class PaymentTransaction extends Transaction {
    int clientId;
    String service;
    String serviceProvider;
    String method ;
    double paidAmount;
    double requiredAmount;
    double clientRestAmount;
    String plan;
    public PaymentTransaction(int clientId,String service,String serviceProvider,String paymentMethod,double paidAmount){
        this.clientId=clientId;
        this.method = paymentMethod ;
        this.service=service;
        this.serviceProvider=serviceProvider;
        this.paidAmount=paidAmount;
        this.type="PaymentTransaction";
    }

    public int getClientId() {
        return clientId;
    }

    public double getPaidAmount() {
        return paidAmount;
    }

    public int getId() {
        return id;
    }

    public  int getTransactionID() {
        return id;
    }

    public String getMethod() {
        return method;
    }

    public String getService() {
        return service;
    }

    public String getServiceProvider() {
        return serviceProvider;
    }

    public void setPaidAmount(double paidAmount) {
        this.paidAmount = paidAmount;
    }

    public void setRequiredAmount(double requiredAmount) {
        this.requiredAmount = requiredAmount;
    }

    public void setClientRestAmount(double restClientAmount) {
        this.clientRestAmount = restClientAmount;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getPlan() {
        return plan;
    }

    public void setService(String service) {
        this.service = service;
    }
}
