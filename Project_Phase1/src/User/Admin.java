package User;

import java.util.LinkedList;
import java.util.Map;

import Discount.DiscountDecorator;
import Providers.ServiceProvider;
import Userdata.Userdata;

public class Admin implements User {

	private String name;
	private String password;
	private Userdata dataobj=Userdata.getInstance();
	private LinkedList<pair>list=new LinkedList();
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
	
	public void addRefundtolist(Client c,ServiceProvider s) {
		pair p=new pair();
		p.first=c;
		p.second=s;
		list.add(p);
	}
	
	public void processRefund(String s) {
		if(list.isEmpty()){
			System.out.println("there is no refund requests");
			return;
		}
		if(s.equals("Accept")) {
			System.out.print("processRefund:accepted for the user ");
			System.out.print(list.getFirst().first.getname());
			System.out.println();
			pair p=new pair();
			p=list.getFirst();
			p.first.fund(p.second.getCost());
			list.pop();
		}
		else {
			System.out.print("processRefund:rejected for the user ");
			System.out.print(list.getFirst().first.getname());
			System.out.println();
			list.pop();
		}
	}
	public void addSpecificDiscount(ServiceProvider provider,double value) {
			provider.addDiscount(value);
	}
	public void addOverallDiscount(ServiceProvider []arr,double value) {
		for (ServiceProvider temp : arr) {
			temp.addDiscount(value);
		}
	}
}
