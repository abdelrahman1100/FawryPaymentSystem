package Providers;

public class ProviderFactory {
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
		
        else if(name.equals("School")) {
        	return new School();
		}
		
        else if(name.equals("NGO")) {
        	return new NGO();
		}
		
        else if(name.equals("CancerHospital")) {
        	return new CancerHospital();
		}
		
        else if(name.equals("MonthlyReceipt")) {
        	return new MonthlyReceipt();
		}
		
        else if(name.equals("QuarterReceipt")) {
        	return new QuarterReceipt();
		}
		
		return null;
	}
}
