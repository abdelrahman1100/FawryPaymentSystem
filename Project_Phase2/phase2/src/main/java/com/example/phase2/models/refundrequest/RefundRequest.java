package com.example.phase2.models.refundrequest;

import com.example.phase2.models.transaction.PaymentTransaction;
import com.example.phase2.models.transaction.Transaction;

public class RefundRequest {
    public static int requestId=1;
    private String status;
    private int id;
    private PaymentTransaction transaction;
    public RefundRequest(PaymentTransaction transaction){
        this.transaction=transaction;
        this.id=requestId;
        this.status="Not specified";
        requestId++;
    }

    public int getId() {
        return id;
    }
    public String getStatus() {
        return status;
    }
    public Transaction getTransaction() {
        return transaction;
    }
    public int getClient() {
        return transaction.getClientId();
    }
    public double getPaidAmount(){
        return transaction.getPaidAmount();
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
