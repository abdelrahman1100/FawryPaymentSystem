package Discount;

import java.util.LinkedList;

import Payment.Payment;
import Payment.Wallet;
import Providers.OrangeMobile;
import Providers.ServiceProvider;
import Services.Service;

public class DiscountDecorator implements Payment{
	
	    private LinkedList<ServiceProvider>list=new LinkedList();
	   
	    public void checkDiscount(ServiceProvider name) {
		boolean ok=false;
		for (ServiceProvider temp : list) {
			   if(temp.getClass().equals(name.getClass())) {
					System.out.println("This ServiceProvider has discount");
					ok=true;
				}
	        }
		   if(!ok) {
			   System.out.println("This ServiceProvider do not have discount");
		   }
	    }

	    @Override
	    public void pay(Service service) {
		// TODO Auto-generated method stub
		
	    }
}
