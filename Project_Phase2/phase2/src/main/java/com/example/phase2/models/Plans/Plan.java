package com.example.phase2.models.Plans;

public class Plan {
	String type;
	double cost;
	public Plan(String type,double cost){
		this.cost=cost;
		this.type=type;
	}
	public double getCost(){
		return cost;
	}
	public void setCost(double c){
		this.cost=c;
	}

	public String getType() {
		return type;
	}
}
