package com.example.phase2.models.serviceproviders;

import com.example.phase2.models.Transaction;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class MobileProvider extends ServiceProvider {
    private String mobilePlan;
    public MobileProvider(String name, double fee, String mobilePlan) {
        super(name,fee);
        this.mobilePlan=mobilePlan;
    }

    public MobileProvider() {
    }

    public String getMobilePlan() {
        return mobilePlan;
    }

    public void setMobilePlan(String mobilePlan) {
        this.mobilePlan = mobilePlan;
    }
}
