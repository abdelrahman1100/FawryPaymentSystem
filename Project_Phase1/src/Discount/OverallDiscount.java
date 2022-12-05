package Discount;

import java.util.LinkedList;

import Payment.Payment;
import Providers.ServiceProvider;
import Services.Service;
public class OverallDiscount extends DiscountDecorator  {
    public OverallDiscount(Payment decoratedPayment)
    {
        super(decoratedPayment);
    }
    public double pay(ServiceProvider service)
    {
    	return addDiscount(decoratedPayment,service);
        
    }
    public double addDiscount(Payment decoratedPayment,ServiceProvider service)
    {
    	return decoratedPayment.pay(service)*service.getDiscount();
    }
}
