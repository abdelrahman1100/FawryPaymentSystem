package Providers;

import java.util.LinkedList;

import Discount.DiscountDecorator;
import Payment.Payment;
import Payment.PaymentFactory;
import Services.Landline;
import Services.Service;

public class QuarterReceipt implements ServiceProvider {
	
	private LinkedList<DiscountDecorator>list=new LinkedList();
	private PaymentFactory paymentfactory;

	@Override
	public void showService() {
		// TODO Auto-generated method stub
		System.out.println("If you want to Pay QuarterReceipt Landline enter Landline");
	}

	@Override
	public void pay(Service service,Payment payment) {
		// TODO Auto-generated method stub
		if(OKService(service)) {
			service.pay(payment);
			Payment cost=payment;
			for (DiscountDecorator temp : list) {
	            temp.pay(payment,new OrangeMobile());
	        }
			cost.pay();
		}
		else {
			System.out.println("Wrong service");
		}
	}


	@Override
	public boolean OKPaymentMethod(Payment payment) {
		// TODO Auto-generated method stub
		return paymentfactory.OKPaymentMethod(payment);
	}

	@Override
	public void ShowPaymentMethod() {
		// TODO Auto-generated method stub
		System.out.println("1-Enter Cashe if you want to pay with cash");
		System.out.println("2-Enter Wallet if you want to pay with wallet");
		System.out.println("3-Enter Creditcard if you want to pay with creditcard");
	}

	@Override
	public boolean OKService(Service service) {
		// TODO Auto-generated method stub
		if(service.getClass().equals(new Landline().getClass())) {
			return true;
		}
		return false;
	}

	@Override
	public void add(DiscountDecorator item) {
		// TODO Auto-generated method stub
		list.add(item);
	}

}
