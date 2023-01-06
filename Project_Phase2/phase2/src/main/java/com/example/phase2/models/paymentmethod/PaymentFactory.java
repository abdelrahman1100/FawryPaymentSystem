package com.example.phase2.models.paymentmethod;


import com.example.phase2.models.paymentmethod.Cash;
import com.example.phase2.models.paymentmethod.CreditCard;
import com.example.phase2.models.paymentmethod.Payment;
import com.example.phase2.models.paymentmethod.Wallet;

public class PaymentFactory {
    public Payment getPayment(String name) {
		
		if(name.equals("Cash")) {
			return new Cash();
		}
		
		else if(name.equals("Wallet")) {
			return new Wallet();
		}
		
        else if(name.equals("CreditCard")) {
        	return new CreditCard();
		}
		
		return null;
	}
}
