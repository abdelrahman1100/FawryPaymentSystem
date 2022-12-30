package com.example.phase2.Services;


import com.example.phase2.Payment.Payment;

import com.example.phase2.Providers.ServiceProvider;


public class MobileRecharge implements Service {
	ServiceProvider provider;
	double additionalCost=0;
	
	public void setProvider(ServiceProvider p) {
		// TODO Auto-generated method stub
		provider=p;
	}
	
	public double getCost() {
		// TODO Auto-generated method stub
		return additionalCost+provider.getCost();
	}

	@Override
	public void showproviderslist() {
		// TODO Auto-generated method stub
		System.out.println("Enter Name Of Service You Want:");
		System.out.println("EtisalateMobile");
		System.out.println("OrangeMobile");
		System.out.println("VodafonMobile");
		System.out.println("WeMobile");
	}

	@Override
	public void ShowPaymentMethod() {
		// TODO Auto-generated method stub
		System.out.println("Enter Name Of Paymentmethod You Want:");
		System.out.println("Cash");
		System.out.println("CreditCard");
		System.out.println("Wallet");
	}

}
