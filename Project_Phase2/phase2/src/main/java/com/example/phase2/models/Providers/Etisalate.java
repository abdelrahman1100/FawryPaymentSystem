package com.example.phase2.models.Providers;

public class Etisalate implements ServiceProvider{
	private double Cost=90;

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
