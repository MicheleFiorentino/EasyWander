package com.easywander.economy;

public class DebitCard extends Card{
	
	//constructor
	public DebitCard(String name, String number, String expirationDate, String owner) {
		super(name, number, expirationDate, owner);
	}
	
	public DebitCard(String userEmail, String name, String number, String expirationDate, String owner) {
		super(userEmail, name, number, expirationDate, owner);
	}
	
}
