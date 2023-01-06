package com.example.phase2.models.Services;


import com.example.phase2.models.Plans.Plan;
import com.example.phase2.models.Providers.ServiceProvider;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedList;

@Component
public class Landline implements Service {
	String name;
	String plan;
	ServiceProvider provider ;
	double additionalCost=0;
	private ArrayList<String> paymentMethods ;
	private LinkedList<Plan>plansList;
	public Landline(){
		this.plansList=new LinkedList<>();
		this.plansList.add(new Plan("MonthlyReceipt",80));
		this.plansList.add(new Plan("QuarterReceipt",50));
		paymentMethods = new ArrayList<>() ;
		paymentMethods.add("Cash") ;
		paymentMethods.add("Credit") ;
		paymentMethods.add("Wallet") ;
	}
	public void setPlan(String p) {
		this.plan=p;
	}
	
	public double getCost() {
		// TODO Auto-generated method stub
		for (Plan p:
				plansList) {
			if(p.getType().equalsIgnoreCase(plan)){
				return p.getCost();
			}
		}
		return 0;
	}

	@Override
	public void showProvidersList() {
		// TODO Auto-generated method stub
		System.out.println("Enter Name Of Service You Want:");
		System.out.println("MonthlyReceipt");
		System.out.println("QuarterReceipt");
		
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
	public double getPlanCost(String name){
		for (Plan plan:
			 plansList) {
			if(plan.getType().equalsIgnoreCase(name)){
				return plan.getCost();
			}
		}
		return 0;
	}

}
