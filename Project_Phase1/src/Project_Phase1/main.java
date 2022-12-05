package Project_Phase1;

import java.util.Scanner;

import javax.security.auth.Subject;

import Discount.DiscountDecorator;
import Discount.OverallDiscount;
import Discount.SpecificDiscount;
import Donations.DonationFactory;
import Donations.DonationProvider;
import Payment.Payment;
import Payment.PaymentFactory;
import Payment.Wallet;
import Plans.Plan;
import Plans.PlanFactory;
import Providers.*;
import Services.Donation;
import Services.InternetPayment;
import Services.Landline;
import Services.MobileRecharge;
import Services.Service;
import Services.ServiceFactory;
import User.Admin;
import User.Client;
import Userdata.Userdata;
import java.util.LinkedList;

public class main {
	public static void main(String[] args) {
		ServiceProvider[] p = {new OrangeInternet(), new EtisalateInternet(), new VodafonInternet(), new WeInternet()
				, new OrangeMobile(), new VodafonMobile(), new EtisalateMobile(), new WeMobile()
		};
		Userdata userdata = Userdata.getInstance();
		userdata.setData("abdo", "2020");//////////// valid user
		Admin admin = new Admin();
		admin.addSpecificDiscount(p[7], 0.2);
		admin.addOverallDiscount(p,0.5);
		Scanner sc = new Scanner(System.in);
		String name, pass;
		int choice;
		Client user1 = new Client();
		System.out.println("If you want to login enter 1 if you want to signup enter 2");
		choice = sc.nextInt();
		if (choice == 1) {
			System.out.println("Enter User Name to login hint the logged user is abdo");
			name = sc.next();
			System.out.println("Enter User password login hint the logged pass is 2020");
			pass = sc.next();
			if (!user1.login(name, pass)) return;
		} else if (choice == 2) {
			System.out.println("Enter User Name to login hint the logged user is abdo");
			name = sc.next();
			System.out.println("Enter User password login hint the logged pass is 2020");
			pass = sc.next();
			user1.signup(name, pass);
		} else {
			System.out.println("error");
			return;
		}
		System.out.println("Enter Name Of Service You Want:");
		System.out.println("InternetPayment");
		System.out.println("MobileRecharge");
		System.out.println("Donation");
		System.out.println("Landline");
		String s = sc.nextLine();
		Service serv = new ServiceFactory().createService(s);
		if (serv == null) {
			System.out.println("sorry service do not exist");
			return;
		}
		if (s.equals("InternetPayment")) {
			serv.showproviderslist();
			s = sc.nextLine();
			ServiceProvider serviceprovider = new ProviderFactory().getProvider(s);
			if (serviceprovider == null) {
				System.out.println("error");
				return;
			}
			InternetPayment servic = new InternetPayment();
			servic.setProvider(serviceprovider);
			serv = servic;
			serv.ShowPaymentMethod();
			s = sc.nextLine();
			Payment pay = new PaymentFactory().getPayment(s);
			if (pay == null) {
				System.out.println("error");
				return;
			}
			System.out.println("if you want to know this service has discount enter check discount");
			s = sc.nextLine();
			if(s.equals("check discount")) {
				specificDiscount.checkDiscount(serviceprovider);
				overallDiscount.checkDiscount(serviceprovider);
			}
			else {
				System.out.println("not correct");
			}
			pay.pay(serv);
			System.out.println("By user "+ user1.getname());
			System.out.println("do you want to refund? Y or N");
			s=sc.nextLine();
			if(s.equals("Y")) {
				user1.Refund(admin);
				System.out.println("Admin: there is a refund do you want to accept? Y or N");
				s=sc.nextLine();
				if(s.equals("Y")) {
					admin.processRefund("Accept");
				}
				else {
					admin.processRefund("reject");
				}
			}
			else {
				return;
			}
		}
		if(s.equals("MobileRecharge")) {
			serv.showproviderslist();
			s=sc.nextLine();
			ServiceProvider serviceprovider=new ProviderFactory().getProvider(s);
			if(serviceprovider==null) {
				System.out.println("error");
				return;
			}
			MobileRecharge servic=new MobileRecharge();
			servic.setProvider(serviceprovider);
			serv=servic;
			serv=servic;
			serv.ShowPaymentMethod();
			s=sc.nextLine();
			Payment pay=new PaymentFactory().getPayment(s);
			if(pay==null) {
				System.out.println("error");
				return;
			}
			System.out.println("if you want to know this service has discount enter check discount");
			s=sc.nextLine();
			if(s.equals("check discount")) {
				specificDiscount.checkDiscount(serviceprovider);
				overallDiscount.checkDiscount(serviceprovider);
			}
			else {
				System.out.println("not correct");
			}
			pay.pay(serv);
			System.out.println("By user "+ user1.getname());
			System.out.println("do you want to refund? Y or N");
			s=sc.nextLine();
			if(s.equals("Y")) {
				user1.Refund(admin);
				System.out.println("Admin: there is a refund do you want to accept? Y or N");
				s=sc.nextLine();
				if(s.equals("Y")) {
					admin.processRefund("Accept");
				}
				else {
					admin.processRefund("reject");
				}
			}
			else {
				return;
			}
		}
		if(s.equals("Donation")) {
			serv.showproviderslist();
			s=sc.nextLine();
			DonationProvider service=new DonationFactory().getDonation(s);
			if(service==null) {
				System.out.println("error");
				return;
			}
			Donation servic=new Donation();
			servic.setDonation(service);
			servic.ShowPaymentMethod();
			s=sc.nextLine();
			Payment pay=new PaymentFactory().getPayment(s);
			if(pay==null) {
				System.out.println("error");
				return;
			}
			pay.pay(servic);
			System.out.println("By user "+ user1.getname());
			System.out.println("do you want to refund? Y or N");
			s=sc.nextLine();
			if(s.equals("Y")) {
				user1.Refund(admin);
				System.out.println("Admin: there is a refund do you want to accept? Y or N");
				s=sc.nextLine();
				if(s.equals("Y")) {
					admin.processRefund("Accept");
				}
				else {
					admin.processRefund("reject");
				}
			}
			else {
				return;
			}
		}
		if(s.equals("Landline")) {
			serv.showproviderslist();
			s=sc.nextLine();
			Plan service=new PlanFactory().getPlan(s);
			if(service==null) {
				System.out.println("error");
				return;
			}
			Landline servic=new Landline();
			servic.setPlan(service);
			servic.ShowPaymentMethod();
			s=sc.nextLine();
			Payment pay=new PaymentFactory().getPayment(s);
			if(pay==null) {
				System.out.println("error");
				return;
			}
			pay.pay(servic);
			System.out.println("By user "+ user1.getname());
			System.out.println("do you want to refund? Y or N");
			s=sc.nextLine();
			if(s.equals("Y")) {
				user1.Refund(admin);
				System.out.println("Admin: there is a refund do you want to accept? Y or N");
				s=sc.nextLine();
				if(s.equals("Y")) {
					admin.processRefund("Accept");
				}
				else {
					admin.processRefund("reject");
				}
			}
			else {
				return;
			}
		}

		}
	}
}