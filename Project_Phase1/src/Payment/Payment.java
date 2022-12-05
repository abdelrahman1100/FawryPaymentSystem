package Payment;

import Providers.ServiceProvider;
import Services.Service;

public interface Payment {
	public double pay(ServiceProvider service);
}
