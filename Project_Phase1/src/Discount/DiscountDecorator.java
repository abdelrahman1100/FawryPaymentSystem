package Discount;

import java.util.LinkedList;

import Donations.DonationProvider;
import Payment.Payment;
import Payment.Wallet;
import Plans.Plan;
import Providers.OrangeMobile;
import Providers.ServiceProvider;
import Services.Service;

public class DiscountDecorator implements Payment{
	    protected Payment decoratedPayment =null;
	    public DiscountDecorator(Payment p){
	    	this.decoratedPayment=p;
	    }
	    @Override
	   public double pay(ServiceProvider service) {
	    	return decoratedPayment.pay(service);
	    }
		@Override
		public double pay(DonationProvider service) {
			// TODO Auto-generated method stub
			return decoratedPayment.pay(service);
		}
		@Override
		public double pay(Plan service) {
			// TODO Auto-generated method stub
			return decoratedPayment.pay(service);
		}

}
