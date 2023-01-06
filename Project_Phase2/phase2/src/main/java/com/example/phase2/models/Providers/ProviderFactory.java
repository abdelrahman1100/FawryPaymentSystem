package com.example.phase2.models.Providers;
public class ProviderFactory  {
	public static ServiceProvider getProvider(String name) {
		
		if(name.toLowerCase().contains("we")) {
			return new We();
		}
		
		else if(name.toLowerCase().contains("orange")) {
			return new Orange();
		}
		
        else if(name.toLowerCase().contains("vodafon")) {
        	return new Vodafon();
		}
		
        else if(name.toLowerCase().contains("etisalat")) {
        	return new Etisalate();
        }
		return null;
	}
	
}
