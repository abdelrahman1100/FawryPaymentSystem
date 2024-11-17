package com.example.phase2.models.serviceproviders;

import com.example.phase2.models.Transaction;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class InternetProvider extends ServiceProvider {
    private String internetPackage;

    public InternetProvider() {
    }

    public InternetProvider(String providerName, double price, String internetPackage) {
        super(providerName, price);
        this.internetPackage = internetPackage;
    }

    public String getInternetPackage() {
        return internetPackage;
    }

    public void setInternetPackage(String internetPackage) {
        this.internetPackage = internetPackage;
    }
}
