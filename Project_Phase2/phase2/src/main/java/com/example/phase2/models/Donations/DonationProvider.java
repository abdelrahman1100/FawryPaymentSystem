package com.example.phase2.models.Donations;

public class DonationProvider {
	String name;
	double amount;
	public DonationProvider(String name){
		this.name=name;
	}
	public double getAmount(){
		return amount;
	}
	public void setAmount(double c){
		this.amount =c;
	}
	public String getName() {
		return name;
	}
}
