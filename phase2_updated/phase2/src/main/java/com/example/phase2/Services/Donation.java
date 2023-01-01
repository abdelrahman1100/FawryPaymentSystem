package com.example.phase2.Services;

import com.example.phase2.Donations.DonationProvider;

import com.example.phase2.Payment.Payment;
import com.example.phase2.Providers.ServiceProvider;

import java.util.ArrayList;

public class Donation implements Service {
    double additionalCost=0;
	DonationProvider donation;
	private ArrayList<String> paymentMethods ;
	ServiceProvider provider ;
	public Donation(){
		paymentMethods = new ArrayList<>() ;
		paymentMethods.add("Cash") ;
		paymentMethods.add("Credit") ;
		paymentMethods.add("Wallet") ;
	}
	public double getDonation() {
		// TODO Auto-generated method stub
		return additionalCost+donation.getDonation();
	}
	
	public void setDonation(DonationProvider p) {
		// TODO Auto-generated method stub
		this.donation=p;
	}
	
	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void showproviderslist() {
		// TODO Auto-generated method stub
		System.out.println("Enter Name Of Service You Want:");
		System.out.println("CancerHospital");
		System.out.println("NGO");
		System.out.println("School");
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
