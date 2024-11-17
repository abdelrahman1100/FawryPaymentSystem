package com.example.phase2.models.serviceproviders;

import com.example.phase2.models.Transaction;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="landline")
public class Landline extends ServiceProvider {
    private String plan;

    public Landline(String providerName, double price, String plan) {
        super(providerName, price);
        this.plan = plan;
    }

    public Landline(){
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }
}
