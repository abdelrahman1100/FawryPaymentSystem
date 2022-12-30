package com.example.phase2.Donations;

import java.util.LinkedList;


import com.example.phase2.Discount.DiscountDecorator;
import com.example.phase2.Payment.Payment;
import com.example.phase2.Payment.PaymentFactory;
import com.example.phase2.Services.Donation;
import com.example.phase2.Services.Service;

public class NGO implements DonationProvider {
	
	double donation;
	@Override
	public void makeDonation(double d) {
		// TODO Auto-generated method stub
		this.donation=d;
	}
	@Override
	public double getDonation() {
		// TODO Auto-generated method stub
		return donation; 
	}
	
}
