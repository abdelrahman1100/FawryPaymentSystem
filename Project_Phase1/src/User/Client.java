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
import Userdata.Userdata;

public class Client implements User {
	private String name;
	private String password;
	private double wallet=0.0;
	private Userdata dataobj=Userdata.getInstance();
	public Client(){
		
	}
	
	public String getname() {
		return this.name;
	}
	
	public String getpassword() {
		return this.password;
	}
	@Override
	public boolean login(String name,String password) {
		this.name=name;
		this.password=password;
		return dataobj.checkData(name, password);
	}

	@Override
	public void signup(String name,String password) {
		// TODO Auto-generated method stub
		this.name=name;
		this.password=password;
		dataobj.setData(name, password);
	}
	
	public void Refund(Admin admin) {
		admin.addRefundtolist(this);
	}
}
