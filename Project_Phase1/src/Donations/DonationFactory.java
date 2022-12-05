package Donations;

import Providers.EtisalateInternet;
import Providers.EtisalateMobile;
import Providers.OrangeInternet;
import Providers.OrangeMobile;
import Providers.ServiceProvider;
import Providers.VodafonInternet;
import Providers.VodafonMobile;
import Providers.WeInternet;
import Providers.WeMobile;

public class DonationFactory {
     public DonationProvider getDonation(String name) {
		
		if(name.equals("CancerHospital")) {
			return new CancerHospital();
		}
		
		else if(name.equals("NGO")) {
			return new NGO();
		}
		
		else if(name.equals("School")) {
			return new School();
		}

		return null;
	 }
}
