package com.example.phase2.Providers;

import java.util.LinkedList;


import com.example.phase2.Discount.DiscountDecorator;
import com.example.phase2.Payment.Payment;
import com.example.phase2.Payment.PaymentFactory;
import com.example.phase2.Services.MobileRecharge;
import com.example.phase2.Services.Service;

public class We implements ServiceProvider {
	private double Cost=0;
	private double discount=1.0;
	

	@Override
	public void update(double discount) {
		// TODO Auto-generated method stub
		this.discount=discount;
	}

	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		return Cost*discount;
	}
	
	@Override
	public void setCost(double c) {
		// TODO Auto-generated method stub
		this.Cost=c;
	}

}
