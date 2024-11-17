package com.example.phase2.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="client")
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long clientId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private double wallet;
	@OneToOne(mappedBy = "client")
	CreditCard creditCard;

	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
	List<Transaction>transactions;

	public Client(){
	}
	public Long getClientId() {
		return clientId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public boolean hasSufficientBalance(double amount) {
		return wallet>=amount;
	}

	public void deductBalance(double amount) {
		wallet-=amount;
	}


	public void addTransaction(Transaction transaction) {
		transactions.add(transaction);
	}
}
