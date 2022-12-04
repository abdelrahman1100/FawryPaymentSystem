package Services;

import Payment.Payment;

public class Donation implements Service {
	
	@Override
	public void pay(Payment payment) {
		// TODO Auto-generated method stub
		System.out.println("Donation Payed Successfully");
	}
}
