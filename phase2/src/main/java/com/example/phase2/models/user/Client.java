package com.example.phase2.models.user;

import jakarta.persistence.*;

@Entity
@Table
public class Client {
	@Id
	private int id;
	private String name;
	private String password;
	private double wallet;
	@JoinColumn
	@OneToOne
	CreditCard creditCard;

	public Client(){
		this.wallet=0;
		this.creditCard=new CreditCard("","",0);
	}

	public Client(double wallet, CreditCard creditCard) {
		this.wallet = wallet;
		this.creditCard = creditCard;
	}


	Boolean available;

	public String getName(){
		return name;
	}
	public String getPassword() {
		return password;
	}


	public int getId() {
		return id;
	}

	public void setAvailable(Boolean available){
		this.available=available;
	}

	public double getWallet() {
		return wallet;
	}

	public void setWallet(double wallet) {
		this.wallet = wallet;
	}

	public CreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}
}
