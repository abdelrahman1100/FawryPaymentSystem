package Payment;

import Donations.DonationProvider;
import Plans.Plan;
import Providers.ServiceProvider;
import Services.Service;

public class Cash implements Payment{

	@Override
	public double pay(ServiceProvider service) {
		// TODO Auto-generated method stub
		//System.out.print("Payed with Cash ");
		return service.getCost();
	}

	@Override
	public double pay(DonationProvider service) {
		// TODO Auto-generated method stub
		return service.getDonation();
	}

	@Override
	public double pay(Plan service) {
		// TODO Auto-generated method stub
		return service.getCost();
	}

}
