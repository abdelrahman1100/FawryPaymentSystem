package com.example.phase2.models.transaction;

import com.example.phase2.models.paymentmethod.CreditCard;

public class AddToWalletTransaction extends Transaction {
    int id;
    double AddedAmount;
    CreditCard creditCard;

    public void setAddedAmount(int addedAmount) {
        AddedAmount = addedAmount;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public AddToWalletTransaction(CreditCard creditCard, double AddedAmount){
        this.AddedAmount=AddedAmount;
        this.creditCard=creditCard;
        this.type="AddToWalletTransaction";
    }

    public int getId() {
        return id;
    }

    public double getAddedAmount() {
        return AddedAmount;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public String getCreditCardId() {
        return creditCard.getCreditCardId();
    }
}
