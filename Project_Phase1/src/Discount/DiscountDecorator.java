package Discount;

import java.util.LinkedList;


import Payment.Payment;
import Payment.Wallet;
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

}
