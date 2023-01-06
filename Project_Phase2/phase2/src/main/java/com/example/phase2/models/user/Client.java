package com.example.phase2.models.user;


import com.example.phase2.models.Providers.ServiceProvider;
import com.example.phase2.models.Services.Service;
import com.example.phase2.models.paymentmethod.CreditCard;
import com.example.phase2.models.paymentmethod.Wallet;
import org.springframework.stereotype.Component;

@Component
public class Client extends User {

	private Wallet wallet;
	private CreditCard creditCard;
	public Wallet getWallet() {
		return wallet;
	}

	public CreditCard getCreditCard() {
		return creditCard;
	}

	public Client(){
		this.role="client";
		this.wallet=new Wallet();
		this.creditCard=new CreditCard();
	}
	public void setName(String name){
		this.name=name;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public void updateWallet(double amount){
		wallet.setAmount(wallet.getAmount()+amount);
	}

	public void setWalletAmount(double walletAmount) {
		this.wallet.setAmount( walletAmount);
	}
	public void setCreditCardAmount(double creditCardAmount) {
		this.creditCard.setAmount(creditCardAmount);
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard=creditCard;
	}
}
