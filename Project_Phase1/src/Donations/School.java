package Donations;

import java.util.LinkedList;

import Discount.DiscountDecorator;
import Payment.Payment;
import Payment.PaymentFactory;
import Services.Donation;
import Services.Service;

public class School implements DonationProvider {
	double donation;
	@Override
	public void makeDonation(double d) {
		// TODO Auto-generated method stub
		this.donation=d;
	}
	@Override
	public double getDonation() {
		// TODO Auto-generated method stub
		return donation; 
	}
}
