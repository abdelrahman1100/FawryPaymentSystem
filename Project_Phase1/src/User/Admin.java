package User;

import java.util.LinkedList;

import Discount.DiscountDecorator;
import Discount.Subject;
import Providers.ServiceProvider;
import Userdata.Userdata;

public class Admin implements User {

	private String name;
	private String password;
	private Userdata dataobj=Userdata.getInstance();
	private LinkedList<Client>list=new LinkedList();
	public Admin(){
		
	}
	
	public void getname() {
		System.out.println(name);
	}
	
	public void getpassword() {
		System.out.println(password);
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
	
	public void addRefundtolist(Client c) {
		list.add(c);
	}
	
	public void processRefund(String s) {
		if(s=="Accept") {
			System.out.print("processRefund:accepted for the user ");
			System.out.print(list.getFirst().getname());
			System.out.println();
			list.pop();
		}
		else {
			System.out.print("processRefund:rejected for the user ");
			System.out.print(list.getFirst().getname());
			System.out.println();
			list.pop();
		}
	}
	public void addDiscount(Subject discount,ServiceProvider provider) {
		discount.subscribe(provider);
	}
	
}
