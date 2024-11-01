package com.example.phase2.models;

import com.example.phase2.models.user.Client;
import jakarta.persistence.*;

@Entity
@Table(name="refund")
public class Refund {
    @Id
    Long id;
    @JoinColumn
    @ManyToOne
    Client client;
    @JoinColumn
    @OneToOne
    Transaction transaction;
    public Refund() {
    }
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}
