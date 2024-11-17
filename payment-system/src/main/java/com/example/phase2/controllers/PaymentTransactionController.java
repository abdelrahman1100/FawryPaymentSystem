package com.example.phase2.controllers;


import com.example.phase2.dto.PaymentRequest;
import com.example.phase2.models.Transaction;
import com.example.phase2.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class PaymentTransactionController {
    TransactionService transactionService;
    @Autowired
    PaymentTransactionController(TransactionService transactionService){
        this.transactionService=transactionService;
    }
    @PostMapping
    public Transaction createTransaction(@RequestBody PaymentRequest paymentRequest){
        return transactionService.createTransaction(paymentRequest);
    }
    @GetMapping
    public List<Transaction> findTransactions(){
        return transactionService.findAll();
    }
    @GetMapping("/{transaction-id}")
    public Transaction findTransactionById(@PathVariable("transaction-id") Long transactionId){
        return transactionService.findByID(transactionId);
    }
}