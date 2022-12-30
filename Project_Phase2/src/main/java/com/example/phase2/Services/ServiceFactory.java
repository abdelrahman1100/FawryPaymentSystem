package com.example.phase2.Services;


public class ServiceFactory {
	public Service createService(String name) {
		
		if(name.equals("Donation")) {
			return new Donation();
		}
		
		else if(name.equals("Landline")) {
			return new Landline();
		}
		
        else if(name.equals("MobileRecharge")) {
        	return new MobileRecharge();
		}
		
        else if(name.equals("InternetPayment")) {
        	return new InternetPayment();
		}
		
		return null;
	}
}
