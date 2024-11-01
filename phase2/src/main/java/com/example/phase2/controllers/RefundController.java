package com.example.phase2.controllers;

import com.example.phase2.models.Refund;
import com.example.phase2.services.RefundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RefundController {
    RefundService refundService;
    @Autowired
    RefundController(RefundService refundService){
        this.refundService=refundService;
    }
    @PostMapping("/refunds")
    ResponseEntity<String>refund(@RequestBody Refund refund){
        refundService.save(refund);
        try{
            return ResponseEntity.ok("Refund is completed successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to refund money.");
        }
    }
}
