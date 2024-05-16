package com.example.phase2.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Refund {
    @Id
    Long id;
    int clientId;
    Long transactionId;

    public Refund(int clientId, Long transactionId) {
        this.clientId = clientId;
        this.transactionId = transactionId;
    }

    public Refund() {

    }
}
