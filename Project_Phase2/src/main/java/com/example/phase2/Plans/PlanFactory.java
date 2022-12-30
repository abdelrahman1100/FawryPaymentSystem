package com.example.phase2.Plans;

import com.example.phase2.Donations.CancerHospital;

import com.example.phase2.Donations.DonationProvider;
import com.example.phase2.Donations.NGO;
import com.example.phase2.Donations.School;

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
