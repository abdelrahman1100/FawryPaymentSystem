package Discount;

import java.util.LinkedList;

import Payment.Payment;
import Providers.ServiceProvider;

public class SpecificDiscount extends DiscountDecorator {
	private LinkedList list=new LinkedList<ServiceProvider>();
	
	public void add(ServiceProvider item) {
		list.add(item);
	}
	
	public void pay(Payment payment,ServiceProvider item) {
		if(list.contains(item))
			System.out.println("25% discount");
	}
	
	public void Subscribe (ServiceProvider item){
		   item.add(this);
    }
	
}
