package Payment;


public class PaymentFactory {
	public boolean OKPaymentMethod(Payment payment) {
		// TODO Auto-generated method stub
		if(payment.getClass().equals(new Cashe().getClass())) {
			return true;
		}
		if(payment.getClass().equals(new CreditCard().getClass())) {
			return true;
		}
		if(payment.getClass().equals(new Wallet().getClass())) {
			return true;
		}
		return false;
	}
	
    public Payment getPayment(String name) {
		
		if(name.equals("Cashe")) {
			return new Cashe();
		}
		
		else if(name.equals("Wallet")) {
			return new Wallet();
		}
		
        else if(name.equals("Creditcard")) {
        	return new CreditCard();
		}
		
		return null;
	}
}
