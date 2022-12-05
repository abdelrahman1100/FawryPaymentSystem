package Services;


import Payment.Payment;
import Providers.ServiceProvider;


public class InternetPayment implements Service {
	ServiceProvider provider;
	double additionalCost=0;
	
	public void setProvider(ServiceProvider p) {
		// TODO Auto-generated method stub
		provider=p;
	}
	
	public double getCost() {
		// TODO Auto-generated method stub
		return additionalCost+provider.getCost();
	}

	@Override
	public void showproviderslist() {
		// TODO Auto-generated method stub
		System.out.println("Enter Name Of Service You Want:");
		System.out.println("EtisalateInternet");
		System.out.println("OrangeInternet");
		System.out.println("VodafonInternet");
		System.out.println("WeInternet");
	}

	@Override
	public void ShowPaymentMethod() {
		// TODO Auto-generated method stub
		System.out.println("Enter Name Of Paymentmethod You Want:");
		System.out.println("Cash");
		System.out.println("CreditCard");
	}
	ServiceProvider getProvider(){
		return provider;
	}
}
