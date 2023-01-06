package com.example.phase2.models.transaction;

public abstract class Transaction {
    int clientId;
    int id;
    String type;
    public int getClientId() {
        return clientId;
    }
    public int getId() {
        return id;
    }

    public void setTransactionID(int id) {
        this.id = id;
    }

    public int getTransactionID() {
        return id;
    }
}
