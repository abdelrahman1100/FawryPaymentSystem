package com.example.phase2.controllers;

import com.example.phase2.services.RefundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RefundController {
    @Autowired
    RefundService refundService;
    @PostMapping("/api/client/{clientId}/Transaction/{transactionId}")
    ResponseEntity<String>refund(@PathVariable int clientId,@PathVariable Long transactionId){
        refundService.makeRefundRequest(clientId,transactionId);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }
}
