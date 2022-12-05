package Payment;

import Services.Service;

public class CreditCard implements Payment {

	@Override
	public void pay(Service service) {
		// TODO Auto-generated method stub
		System.out.println("Payed with CreditCard "+service.getCost());
	}

}
