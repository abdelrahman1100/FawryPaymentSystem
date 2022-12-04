package Providers;

import Discount.DiscountDecorator;
import Payment.Payment;
import Services.Service;

public interface ServiceProvider {
	public boolean OKPaymentMethod(Payment payment);
	public void ShowPaymentMethod();
	public void showService();
	public boolean OKService(Service service);
	public void pay(Service service,Payment payment);
	public void add(DiscountDecorator item);
}
