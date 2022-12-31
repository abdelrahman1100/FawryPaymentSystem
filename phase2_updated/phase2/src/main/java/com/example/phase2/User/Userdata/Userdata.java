package com.example.phase2.User.Userdata;

import com.example.phase2.User.models.Admin;
import com.example.phase2.User.models.User;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
@Component
public class Userdata {
	private LinkedList<User> usersList;
	private LinkedList<User>activeUsers;
	
	public Userdata() {
		usersList =new LinkedList<>();
		activeUsers=new LinkedList<>();
		usersList.add(new Admin("ahmed","admin-1",1));
		usersList.add(new Admin("mohamed","admin-2",2));
	}
	public void addUser(User user){
		usersList.add(user);
	}
	public void removeUser(int id){
		usersList.remove(getUser(id));
	}
	public boolean isExist(User user){
		for (User u: usersList) {
			if(u.getName().equals(user.getName())&&u.getRole().equals(user.getRole())){
				return true;
			}
		}
		return false;
	}
	public boolean checkCardinality(User user){
		for (User u: usersList) {
			if(u.getName().equals(user.getName())&&u.getPassword().equals(user.getPassword())&&u.getRole().equals(user.getRole())){
				return true;
			}
		}
		return false;
	}
	public User getUser(int id){
		for (User u: usersList) {
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
	public boolean isActive(int id,String role){
		for (User u: activeUsers) {
			if(u.getId()==(id)){
				if(role.equals(u.getRole())) {
					return true;
				}
			}
		}
	return false;
	}
	// added by ahmed ezz , used at operation() endpoint
	public boolean findById(int id){
		for(User u : usersList){
			if(u.getId()==id)
				return true ;
		}
		return false ;
	}
}
