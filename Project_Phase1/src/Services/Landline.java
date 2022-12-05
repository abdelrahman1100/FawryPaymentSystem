package Services;


import Payment.Payment;
import Plans.Plan;
import Providers.ServiceProvider;


public class Landline implements Service {
	
	Plan plan;
	
	double additionalCost=0;
	
	public void setPlan(Plan p) {
		this.plan=p;
	}
	
	public double getCost() {
		// TODO Auto-generated method stub
		return additionalCost+plan.getCost();
	}

	@Override
	public void showproviderslist() {
		// TODO Auto-generated method stub
		System.out.println("Enter Name Of Service You Want:");
		System.out.println("MonthlyReceipt");
		System.out.println("QuarterReceipt");
		
	}

	@Override
	public void ShowPaymentMethod() {
		// TODO Auto-generated method stub
		System.out.println("Enter Name Of Paymentmethod You Want:");
		System.out.println("Cash");
		System.out.println("CreditCard");
	}
	
}
