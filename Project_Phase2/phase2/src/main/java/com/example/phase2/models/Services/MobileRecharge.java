package com.example.phase2.models.Services;


import com.example.phase2.models.Providers.ServiceProvider;

import java.util.ArrayList;


public class MobileRecharge implements Service {
	String name="mobile";
	double additionalCost=0;
	private ArrayList<String> paymentMethods ;
	ServiceProvider provider ;
	public MobileRecharge(){
		paymentMethods = new ArrayList<>() ;
		paymentMethods.add("Cash") ;
		paymentMethods.add("Credit") ;
		paymentMethods.add("Wallet") ;
	}
	@Override
	public void setProvider(ServiceProvider p) {
		// TODO Auto-generated method stub
		provider=p;
	}
	
	public double getCost() {
		// TODO Auto-generated method stub
		return additionalCost+provider.getCost();
	}

	@Override
	public void showProvidersList() {
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
	@Override
	public boolean checkPaymentMethod(String paymentMethod){
		for(String p : paymentMethods){
			if(p.toLowerCase().equals(paymentMethod.toLowerCase()))
				return true ;
		}
		return false ;
	}
	@Override
	public ServiceProvider getProvider() {
		return provider;
	}
	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name=name;
	}
}
