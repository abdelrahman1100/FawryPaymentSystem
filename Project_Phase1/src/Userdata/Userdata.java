package Userdata;

import java.util.LinkedList;

import Providers.ServiceProvider;

public class Userdata {
	
	private static Userdata instance = new Userdata();
	private LinkedList<String>list=new LinkedList();
	
	private Userdata() {
	}
	
	public static Userdata getInstance(){
	      return instance;
	}
	
	public void setData(String name,String pass){
		list.add(name);
		list.add(pass);
	}
	
	public boolean checkData(String name,String pass){
		if((!list.contains(name))||(!list.contains(pass))) {
			System.out.println("Can not log in");
			return false;
		}
		System.out.println("logged in");
		return true;
	}
}
