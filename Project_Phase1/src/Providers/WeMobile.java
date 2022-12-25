package Providers;

import java.util.LinkedList;

import Discount.DiscountDecorator;
import Payment.Payment;
import Payment.PaymentFactory;
import Services.MobileRecharge;
import Services.Service;

public class WeMobile implements ServiceProvider {
	private double Cost=0;
	private double discount=1.0;
	

	@Override
	public void update(double discount) {
		// TODO Auto-generated method stub
		this.discount=discount;
	}

	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		return Cost*discount;
	}
	
	@Override
	public void setCost(double c) {
		// TODO Auto-generated method stub
		this.Cost=c;
	}

}
