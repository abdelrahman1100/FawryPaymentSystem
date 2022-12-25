package Payment;

import Services.Service;

public class Cash implements Payment{

	@Override
	public void pay(Service service) {
		// TODO Auto-generated method stub
		System.out.println("Payed with Cash "+service.getCost());
	}

}
