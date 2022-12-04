package User;

import java.util.Scanner;

import Discount.DiscountDecorator;
import Discount.OverallDiscount;
import Payment.Payment;
import Payment.PaymentFactory;
import Providers.ProviderFactory;
import Providers.ServiceProvider;
import Services.Service;
import Services.ServiceFactory;

public class Client {
	private String name;
	private String password;
	public Client(String name,String password){
		this.name=name;
		this.password=password;
	}
	public void getname() {
		System.out.println(name);
	}
	public void getpassword() {
		System.out.println(password);
	}
}
