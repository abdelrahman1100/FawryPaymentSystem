package Payment;

import Providers.ServiceProvider;
import Services.Service;

public class CreditCard implements Payment {

	
	@Override
	public double pay(ServiceProvider service) {
		// TODO Auto-generated method stub
		//System.out.print("Payed with CreditCard ");
		return service.getCost();
	}

}
