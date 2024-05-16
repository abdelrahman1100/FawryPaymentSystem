package com.example.phase2.services;

import com.example.phase2.models.Transaction;
import com.example.phase2.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;

    public void createTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    Transaction findByID(Long id) {
        return transactionRepository.findById(id).get();
    }
}
   