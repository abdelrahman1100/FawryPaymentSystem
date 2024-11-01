package com.example.phase2.models.user;

import com.example.phase2.models.Refund;
import com.example.phase2.models.Transaction;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="client")
public class Client {
	@Id
	@Column(name="id")
	private Long id;
	@Column(name="name")
	private String name;
	@Column(name="password")
	private String password;
	@Column(name="wallet")
	private double wallet;
	@JoinColumn
	@OneToOne
	CreditCard creditCard;
	@JoinColumn
	@OneToMany
	List<Refund>refunds;
	@JoinColumn
	@OneToMany
	List<Transaction>transactions;

	public Client(){
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public List<Refund> getRefunds() {
		return refunds;
	}

	public void setRefunds(List<Refund> refunds) {
		this.refunds = refunds;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
}
