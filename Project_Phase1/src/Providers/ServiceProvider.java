package Providers;

import Discount.DiscountDecorator;
import Payment.Payment;
import Services.Service;

public interface ServiceProvider {

	public double getCost();
	public void setCost(double c);
	void addDiscount(double v);
	double getDiscount();
	void removeDiscount();
}
