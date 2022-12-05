package Payment;

import Donations.DonationProvider;
import Plans.Plan;
import Providers.ServiceProvider;
import Services.Service;

public interface Payment {
	public double pay(ServiceProvider service);
	public double pay(DonationProvider service);
	public double pay(Plan service);
}
