package com.example.phase2.models.discount;

public class SpecificDiscount extends Discount {
    String service;
    public SpecificDiscount(String service,Double discountValue){
        this.service=service;
        this.discountValue=discountValue;
        this.type="SpecificDiscount";
    }

    public String getService() {
        return service;
    }
}
