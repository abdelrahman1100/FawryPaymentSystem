package com.example.phase2.User.models;


import com.example.phase2.Providers.ServiceProvider;
import com.example.phase2.Services.Service;
public class Client extends User {

	private ServiceProvider p;
	private Service s;
	private double wallet=0.0;
	public double getWallet() {
		return wallet;
	}
	public Client(String name,String password){
		this.name=name;
		this.password=password;
		this.role="client";
	}

	public void updateWallet(double amount){
		wallet+=amount;
	}
	public void setservice(String s) {
		// TODO Auto-generated method stub

	}

}
