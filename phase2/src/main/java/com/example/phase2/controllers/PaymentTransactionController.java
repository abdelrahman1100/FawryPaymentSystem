package com.example.phase2.controllers;


import com.example.phase2.models.Transaction;
import com.example.phase2.services.*;
import com.example.phase2.services.LandlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PaymentTransactionController {
    TransactionService transactionService;
    @Autowired
    PaymentTransactionController(TransactionService transactionService){
        this.transactionService=transactionService;
    }
    @PostMapping("/transactions")
    public ResponseEntity<String> save(@RequestBody Transaction transaction){
        try {
            transactionService.save(transaction);
            return ResponseEntity.ok("Transaction is completed successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to complete transaction.");
        }
    }
}