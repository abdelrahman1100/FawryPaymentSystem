package Providers;

import java.util.LinkedList;

import Discount.DiscountDecorator;
import Payment.Payment;
import Payment.PaymentFactory;
import Services.InternetPayment;
import Services.Service;

public class EtisalateInternet implements ServiceProvider{
	private double Cost=0;
	private double discount=1.0;
	@Override
	public void addDiscount(double v){
		this.discount=v;
	}
	@Override
	public double getDiscount(){
		return discount;
	}
	@Override
	public void removeDiscount(){
		this.discount=1.0;
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
