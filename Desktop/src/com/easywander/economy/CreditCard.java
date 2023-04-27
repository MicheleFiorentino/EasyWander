package com.easywander.economy;

public class CreditCard extends Card{
	
	//constructor
	public CreditCard(String name, String number, String expirationDate, String owner) {
		super(name, number, expirationDate, owner);
	}
	
	public CreditCard(String userEmail, String name, String number, String expirationDate, String owner) {
		super(userEmail, name, number, expirationDate, owner);
	}
}
