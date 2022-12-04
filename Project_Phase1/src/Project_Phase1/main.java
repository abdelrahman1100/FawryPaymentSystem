package Project_Phase1;

import java.util.Scanner;

import Discount.DiscountDecorator;
import Discount.OverallDiscount;
import Payment.Payment;
import Payment.PaymentFactory;
import Payment.Wallet;
import Providers.OrangeMobile;
import Providers.ProviderFactory;
import Providers.ServiceProvider;
import Services.Landline;
import Services.MobileRecharge;
import Services.Service;
import Services.ServiceFactory;
import User.Client;

public class main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String name,pass;
		System.out.println("Enter User Name");
		name=sc.nextLine();
		System.out.println("Enter User password");
		pass=sc.nextLine();
		Client user1=new Client(name,pass);
		System.out.println("Enter Name Of Service You Want:");
		System.out.println("CancerHospital");
		System.out.println("EtisalateInternet");
		System.out.println("EtisalateMobile");
		System.out.println("MonthlyReceipt");
		System.out.println("NGO");
		System.out.println("OrangeInternet");
		System.out.println("OrangeMobile");
		System.out.println("QuarterReceipt");
		System.out.println("School");
		System.out.println("VodafonInternet");
		System.out.println("VodafonMobile");
		System.out.println("WeInternet");
		System.out.println("WeMobile");
		String s;
		s=sc.nextLine();
		ServiceProvider service=new ProviderFactory().getProvider(s);
		if(service==null) {
			System.out.println("error");
			return;
		}
		service.showService();
		s=sc.nextLine();
		Service serv=new ServiceFactory().getService(s);
		if(serv==null) {
			System.out.println("error");
			return;
		}
		service.ShowPaymentMethod();
		s=sc.nextLine();
		Payment pay=new PaymentFactory().getPayment(s);
		if(pay==null) {
			System.out.println("error");
			return;
		}
		service.pay(serv, pay);
		System.out.println("By user "
				+ name);
	}
}