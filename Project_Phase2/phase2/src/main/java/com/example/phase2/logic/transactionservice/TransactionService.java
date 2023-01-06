package com.example.phase2.logic.transactionservice;

import com.example.phase2.databases.TransactionData;
import com.example.phase2.models.transaction.Transaction;
import org.springframework.stereotype.Component;


public class TransactionService {
    public static int cntTransaction=1;
    private TransactionData transactionData;
    public TransactionService(TransactionData transactionData){
        this.transactionData=transactionData;
    }
    public void addTransaction(Transaction transaction){
        transaction.setTransactionID(cntTransaction);
        cntTransaction++;
        transactionData.addTransaction(transaction);
    }
}
