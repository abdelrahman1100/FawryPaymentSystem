package com.example.phase2.Services;


import com.example.phase2.Payment.Payment;

import com.example.phase2.Plans.Plan;
import com.example.phase2.Providers.ServiceProvider;

import java.util.ArrayList;


public class Landline implements Service {
	
	Plan plan;
	ServiceProvider provider ;
	double additionalCost=0;
	private ArrayList<String> paymentMethods ;
	public Landline(){
		paymentMethods = new ArrayList<>() ;
		paymentMethods.add("Cash") ;
		paymentMethods.add("Credit") ;
		paymentMethods.add("Wallet") ;
	}
	public void setPlan(Plan p) {
		this.plan=p;
	}
	
	public double getCost() {
		// TODO Auto-generated method stub
		return additionalCost+plan.getCost();
	}

	@Override
	public void showproviderslist() {
		// TODO Auto-generated method stub
		System.out.println("Enter Name Of Service You Want:");
		System.out.println("MonthlyReceipt");
		System.out.println("QuarterReceipt");
		
	}

	@Override
	public void ShowPaymentMethod() {
		// TODO Auto-generated method stub
		System.out.println("Enter Name Of Paymentmethod You Want:");
		System.out.println("Cash");
		System.out.println("CreditCard");
	}
	@Override
	public void setProvider(ServiceProvider provider){
		this.provider = provider ;
	}
	@Override
	public boolean checkPaymentMethod(String paymentMethod){
		for(String p : paymentMethods){
			if(p.toLowerCase().equals(paymentMethod.toLowerCase()))
				return true ;
		}
		return false ;
	}
}
