package Discount;

import java.util.LinkedList;

import Payment.Payment;
import Providers.ServiceProvider;
import Services.Service;

public class SpecificDiscount extends DiscountDecorator {
    public SpecificDiscount(Payment decoratedPayment)
    {
        super(decoratedPayment);
    }
    public double pay(ServiceProvider provider)
    {

    	return setDiscountValue(decoratedPayment,provider);
        
    }
    public double setDiscountValue(Payment decoratedPayment,ServiceProvider service)
    {

    	return decoratedPayment.pay(service)*service.getDiscount();
    }
}
