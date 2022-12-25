package Providers;

import Discount.DiscountDecorator;
import Payment.Payment;
import Services.Service;

public interface ServiceProvider {
	public void update(double discount);
	public double getCost();
	public void setCost(double c);
}
