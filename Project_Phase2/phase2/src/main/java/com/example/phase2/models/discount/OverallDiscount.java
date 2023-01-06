package com.example.phase2.models.discount;


public class OverallDiscount extends Discount {
    public OverallDiscount(Double discountValue){
        this.discountValue=discountValue;
        this.type="OverallDiscount";
    }
}
