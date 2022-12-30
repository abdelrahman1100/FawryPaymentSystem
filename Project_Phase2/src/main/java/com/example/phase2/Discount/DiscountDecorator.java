package com.example.phase2.Discount;

import java.util.LinkedList;


import com.example.phase2.Payment.Payment;
import com.example.phase2.Payment.Wallet;
import com.example.phase2.Providers.Orange;
import com.example.phase2.Providers.ServiceProvider;
import com.example.phase2.Services.Service;

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
