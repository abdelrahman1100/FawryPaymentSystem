package com.example.phase2.Services;



import com.example.phase2.Payment.Payment;
import com.example.phase2.Providers.ServiceProvider;

import java.util.ArrayList;


public class InternetPayment implements Service {
	ServiceProvider provider;
	double additionalCost=0;
	private ArrayList<String> paymentMethods ;
	public InternetPayment(){
		paymentMethods = new ArrayList<>() ;
		paymentMethods.add("Cash") ;
		paymentMethods.add("Credit") ;
		paymentMethods.add("Wallet") ;
	}
	
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
		System.out.println("EtisalateInternet");
		System.out.println("OrangeInternet");
		System.out.println("VodafonInternet");
		System.out.println("WeInternet");
	}

	@Override
	public void ShowPaymentMethod() {
		// TODO Auto-generated method stub
		// System.out.println("Enter Name Of Payment method You Want:");
		System.out.println("Cash");
		System.out.println("CreditCard");
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
