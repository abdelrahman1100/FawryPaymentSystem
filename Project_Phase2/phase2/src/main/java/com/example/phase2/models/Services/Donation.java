package com.example.phase2.models.Services;

import com.example.phase2.models.Donations.DonationProvider;

import com.example.phase2.models.Providers.ServiceProvider;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedList;
@Component
public class Donation implements Service {
	String name;
    double additionalCost=0;
	DonationProvider donation;
	private ArrayList<String> paymentMethods ;
	LinkedList<DonationProvider>donationsList;
	ServiceProvider provider ;
	public Donation(){
		this.donationsList=new LinkedList<>();
		donationsList.add(new DonationProvider("CancerHospital"));
		donationsList.add(new DonationProvider("Schools"));
		donationsList.add(new DonationProvider("NGOs"));
		paymentMethods = new ArrayList<>() ;
		paymentMethods.add("Cash") ;
		paymentMethods.add("Credit") ;
		paymentMethods.add("Wallet") ;
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
	public void showProvidersList() {
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
	public void setDonationAmount(String name,double amount){
		for (DonationProvider donationProvider:
			 donationsList) {
			if(donationProvider.getName().equalsIgnoreCase(name)){
				donationProvider.setAmount(donationProvider.getAmount()+amount);
			}
		}
	}
}
