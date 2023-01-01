package com.example.phase2.Services;

import com.example.phase2.Payment.Payment;

import com.example.phase2.Providers.ServiceProvider;
import com.example.phase2.Providers.We;

import java.security.Provider;
import java.util.ArrayList;

public interface Service {

	public double getCost();
	public void showproviderslist();
	public void ShowPaymentMethod();

	public void setProvider(ServiceProvider provider);
	public boolean checkPaymentMethod(String paymentMethod) ;
}
