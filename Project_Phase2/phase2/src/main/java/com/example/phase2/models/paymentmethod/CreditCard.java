package com.example.phase2.models.paymentmethod;

import com.example.phase2.models.paymentmethod.Payment;

public class CreditCard extends Payment {
	String creditCardId;
	String creditCardPassword;
	public CreditCard(){
		this.amount=1000;
	}
	public void setCreditCardId(String creditCardId) {
		this.creditCardId = creditCardId;
	}

	public void setPassword(String password) {
		this.creditCardPassword = password;
	}

	public String getCreditCardId() {
		return creditCardId;
	}

	public double getAmount(){
		return this.amount;
	}
	public String getPassword() {
		return creditCardPassword;
	}
}
