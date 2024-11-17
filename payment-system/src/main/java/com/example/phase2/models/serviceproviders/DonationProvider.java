package com.example.phase2.models.serviceproviders;

import com.example.phase2.models.Transaction;
import jakarta.persistence.*;

import java.util.List;

@Entity

public class DonationProvider extends ServiceProvider{
    String cause;
    public DonationProvider(String providerName, double price, String cause) {
        super(providerName, price);
        this.cause = cause;
    }

    public DonationProvider() {
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }
}
