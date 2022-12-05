package Plans;

import Donations.CancerHospital;
import Donations.DonationProvider;
import Donations.NGO;
import Donations.School;

public class PlanFactory {
public Plan getPlan(String name) {
		
		if(name.equals("MonthlyReceipt")) {
			return new MonthlyReceipt();
		}
		
		else if(name.equals("QuarterReceipt")) {
			return new QuarterReceipt();
		}
		
		return null;
	 }
}
