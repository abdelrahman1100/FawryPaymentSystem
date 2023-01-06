package com.example.phase2.models.discount;

import org.springframework.stereotype.Component;

public abstract class Discount {
    protected String type;
    protected Double discountValue;

    public void setDiscountValue(Double discountValue) {
        this.discountValue = discountValue;
    }
    public Double getDiscountValue() {
        return discountValue;
    }

    public String getType() {
        return this.type;
    }

}
