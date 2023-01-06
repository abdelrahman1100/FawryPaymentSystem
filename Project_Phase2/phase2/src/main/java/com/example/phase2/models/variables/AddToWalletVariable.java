package com.example.phase2.models.variables;

public class AddToWalletVariable {
    double Amount;
    String creditCardId;
    String creditCardPassword;
    public AddToWalletVariable(String creditCardId,String creditCardPassword,double Amount){
        this.creditCardId=creditCardId;
        this.creditCardPassword=creditCardPassword;
        this.Amount=Amount;
    }
    public String getCreditCardPassword() {
        return creditCardPassword;
    }

    public String getCreditCardId() {
        return creditCardId;
    }

    public double getAddedAmount() {
        return Amount;
    }
}
