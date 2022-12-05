package Payment;

import Providers.ServiceProvider;
import Services.Service;

public class Wallet implements Payment{

	@Override
	public double pay(ServiceProvider service) {
		// TODO Auto-generated method stub
		//System.out.print("Payed with Wallet ");
		return service.getCost();
	}
	
}
