package com.example.phase2.databases;

import com.example.phase2.models.paymentmethod.CreditCard;
import com.example.phase2.models.user.Admin;
import com.example.phase2.models.user.User;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
@Component
public class Userdata {
	private LinkedList<User> usersList;
	private LinkedList<User>activeUsers;
	private LinkedList<CreditCard>clientCreditCards;
	
	public Userdata() {
		this.clientCreditCards=new LinkedList<>();
		usersList =new LinkedList<>();
		activeUsers=new LinkedList<>();
		usersList.add(new Admin("ahmed","admin-1",1));
		usersList.add(new Admin("mohamed","admin-2",2));
	}
	public void addUser(User user){
		usersList.add(user);
	}
	public void removeUser(int id,String role){
		usersList.remove(getUser(id,role));
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
	public User getUser(int id,String role){
		for (User u: usersList) {
			if(u.getId()==id&&u.getRole().equalsIgnoreCase(role)){
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
	public User matchUser(User user){
		for (User u: usersList) {
			if(u.getName().equals(user.getName())&&u.getPassword().equals(user.getPassword())&&u.getRole().equals(user.getRole())){
				return u;
			}
		}
		return null;
	}
	// added by ahmed ezz , used at operation() endpoint
	public boolean findById(int id){
		for(User u : usersList){
			if(u.getId()==id)
				return true ;
		}
		return false ;
	}
	public boolean validateCreditCard(CreditCard card){
		for (CreditCard creditCard: clientCreditCards) {
			if(card.getCreditCardId().equals(creditCard.getCreditCardId())&&card.getPassword().equals(creditCard.getPassword())){
				return true;
			}
		}
		return false;
	}

	public void addCreditCard(CreditCard creditCard) {
		clientCreditCards.add(creditCard);
	}
}
