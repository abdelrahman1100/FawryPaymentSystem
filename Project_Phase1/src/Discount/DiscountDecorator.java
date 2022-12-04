package Discount;

import Payment.Payment;
import Providers.ServiceProvider;

public class DiscountDecorator implements Payment{

	   protected Payment PaymentDiscount;

	   @Override
	   public void pay(){
		   PaymentDiscount.pay();
	   }
	   
	   public void pay(Payment payment,ServiceProvider item){
		   payment.pay();
	   }
	   
	   public void Subscribe (ServiceProvider item){
		   item.add(this);
	   }
}
