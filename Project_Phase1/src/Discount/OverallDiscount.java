package Discount;

import Payment.Payment;
import Providers.ServiceProvider;

public class OverallDiscount extends DiscountDecorator {

	
	public void pay(Payment payment,ServiceProvider item) {
		System.out.println("10% discount");
	}
	
	public void Subscribe (ServiceProvider item){
		   item.add(this);
	}

}
