package Services;

import Payment.Payment;
import Providers.ServiceProvider;
import Providers.WeMobile;

public interface Service {
	public double getCost();
	public void showproviderslist();
	public void ShowPaymentMethod();

}
