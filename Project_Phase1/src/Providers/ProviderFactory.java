package Providers;

import Donations.CancerHospital;

public class ProviderFactory  {
	public ServiceProvider getProvider(String name) {
		
		if(name.equals("WeMobile")) {
			return new WeMobile();
		}
		
		else if(name.equals("OrangeMobile")) {
			return new OrangeMobile();
		}
		
        else if(name.equals("VodafonMobile")) {
        	return new VodafonMobile();
		}
		
        else if(name.equals("EtisalateMobile")) {
        	return new EtisalateMobile();
		}
		
        else if(name.equals("EtisalateInternet")) {
        	return new EtisalateInternet();
		}
		
        else if(name.equals("OrangeInternet")) {
        	return new OrangeInternet();
		}
		
        else if(name.equals("WeInternet")) {
        	return new WeInternet();
		}
		
        else if(name.equals("VodafonInternet")) {
        	return new VodafonInternet();
		}
		
		return null;
	}
	
}
