package com.example.phase2.User.Userdata;

import com.example.phase2.User.models.Admin;
import com.example.phase2.User.models.User;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
@Component
public class Userdata {

	private LinkedList<User>list;
	private LinkedList<User>activeUsers;
	
	public Userdata() {
		list=new LinkedList<>();
		activeUsers=new LinkedList<>();
		list.add(new Admin("ahmed","admin-1","admin"));
		list.add(new Admin("mohamed","admin-2","admin"));
	}
	public void addUser(User user){
		list.add(user);
	}
	public void removeUser(int id){
		list.remove(getUser(id));
	}
	public boolean isExist(User user){
		for (User u: list) {
			if(u==user){
				return true;
			}
		}
		return false;
	}
	public User getUser(int id){
		for (User u: list) {
			if(u.getId()==id){
				return u;
			}
		}
		//handel exception
		return null;
	}
	public void active(User user){
		activeUsers.add(user);
	}

}
