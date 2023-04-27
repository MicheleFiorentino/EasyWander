package com.easywander.rentals;
import java.util.ArrayList;

public class History {
	
	private String userEmail;
	private ArrayList<Rental> rentals = new ArrayList<Rental>();
	
	//getter
	public String getUserEmail() { return userEmail; }
	public ArrayList<Rental> getRentals() { return rentals; }
	
	//constructor
	public History(String userEmail) {
		this.userEmail = userEmail;
	}
	
	//methods
	public ArrayList<String> show(){
		ArrayList<String> history = new ArrayList<String>();
		
		//getInfo() based on userEmail
		
		
		return history;
	}
	
}
