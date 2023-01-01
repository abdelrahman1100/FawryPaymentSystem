package com.example.phase2.User;

import com.example.phase2.User.models.RefundRequest;
import com.example.phase2.User.models.Transaction;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
@Component
public class TransactionData {
    LinkedList<Transaction> transactions;
    public TransactionData() {
        transactions =new LinkedList<>();
    }
    public void addTransaction(Transaction transaction){
        transactions.add(transaction);
    }
    public void removeTransaction(int id){
        transactions.remove(getTransaction(id));
    }
    public Transaction getTransaction(int id){
        for (Transaction t: transactions) {
            if(t.getId()==id){
                return t;
            }
        }
        //handel exception
        return null;
    }
}
