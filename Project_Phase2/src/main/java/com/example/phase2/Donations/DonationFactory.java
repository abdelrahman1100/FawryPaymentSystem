package com.example.phase2.Donations;

import com.example.phase2.Providers.Etisalate;

import com.example.phase2.Providers.Etisalate;
import com.example.phase2.Providers.Orange;
import com.example.phase2.Providers.ServiceProvider;
import com.example.phase2.Providers.Vodafon;
import com.example.phase2.Providers.We;

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
