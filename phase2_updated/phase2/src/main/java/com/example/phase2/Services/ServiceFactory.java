package com.example.phase2.Services;


public class ServiceFactory {
	public static Service createService(String name) {
		
		if(name.toLowerCase().contains("donat")) {
			return new Donation();
		}
		
		else if(name.toLowerCase().contains("landline")) {
			return new Landline();
		}
		
        else if(name.toLowerCase().contains("mobile")) {
        	return new MobileRecharge();
		}
		
        else if(name.toLowerCase().contains("internet")) {
        	return new InternetPayment();
		}
		return null;
	}
}
