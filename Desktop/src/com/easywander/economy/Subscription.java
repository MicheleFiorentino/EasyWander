package com.easywander.economy;

public class Subscription {
	private String name;
	private float cost;
	
	//setter
	public void setName(String name) { this.name = name; }
	public void setCost(float cost) { this.cost = cost; }
	
	//getter
	public String getName() { return name; }
	public float getCost() { return cost; }
	
	//constructor
	public Subscription(String name, float cost) {
		setName(name);
		setCost(cost);
	}
}
