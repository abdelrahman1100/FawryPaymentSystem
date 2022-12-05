package Payment;


public class PaymentFactory {
    public Payment getPayment(String name) {
		
		if(name.equals("Cash")) {
			return new Cash();
		}
		
		else if(name.equals("Wallet")) {
			return new Wallet();
		}
		
        else if(name.equals("CreditCard")) {
        	return new CreditCard();
		}
		
		return null;
	}
}
