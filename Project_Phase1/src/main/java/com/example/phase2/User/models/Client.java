package com.example.phase2.User.models;


import com.example.phase2.User.Userdata.Userdata;
public class Client extends User {
	public static int cnt=1;
	private double wallet=0.0;
	public double getWallet() {
		return wallet;
	}
	public Client(String name,String password,String role){
		this.name=name;
		this.password=password;
		this.role=role;
		this.id=cnt;
		cnt++;
	}
}
