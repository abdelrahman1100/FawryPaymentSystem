package com.example.phase2.Providers;

import com.example.phase2.Donations.CancerHospital;

public class ProviderFactory  {
	public ServiceProvider getProvider(String name) {
		
		if(name.equals("We")) {
			return new We();
		}
		
		else if(name.equals("Orange")) {
			return new Orange();
		}
		
        else if(name.equals("Vodafon")) {
        	return new Vodafon();
		}
		
        else if(name.equals("Etisalate")) {
        	return new Etisalate();
        }
		
		return null;
	}
	
}
