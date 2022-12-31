package com.example.phase2.User.models;

public class Transaction {
    public static int transactionID=1;
    int clientId;
    String service;
    String serviceProvider;
    String method ;
    int id;
    int paidAmount;
    public Transaction(int clientId,String service,String serviceProvider,String paymentMethod,int paidAmount){
        this.clientId=clientId;
        this.method = paymentMethod ;
        this.service=service;
        this.serviceProvider=serviceProvider;
        this.id=transactionID;
        this.paidAmount=paidAmount;
        transactionID++;
    }

    public int getClientId() {
        return clientId;
    }

    public int getPaidAmount() {
        return paidAmount;
    }

    public int getId() {
        return id;
    }

    public static int getTransactionID() {
        return transactionID;
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

}
