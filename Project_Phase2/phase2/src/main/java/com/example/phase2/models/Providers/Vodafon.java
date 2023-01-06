package com.example.phase2.models.Providers;


public class Vodafon implements ServiceProvider{
	private double Cost=100;

	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		return Cost;
	}
	
	@Override
	public void setCost(double c) {
		// TODO Auto-generated method stub
		this.Cost=c;
	}

}
