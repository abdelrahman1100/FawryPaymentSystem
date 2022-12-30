package com.example.phase2.Providers;

import com.example.phase2.Discount.DiscountDecorator;

import com.example.phase2.Payment.Payment;
import com.example.phase2.Services.Service;

public interface ServiceProvider {
	public void update(double discount);
	public double getCost();
	public void setCost(double c);
}
