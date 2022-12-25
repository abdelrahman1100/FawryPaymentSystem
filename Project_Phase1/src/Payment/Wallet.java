package Payment;

import Services.Service;

public class Wallet implements Payment{

	@Override
	public void pay(Service service) {
		// TODO Auto-generated method stub
		System.out.println("Payed with Wallet "+service.getCost());
	}
	
}
