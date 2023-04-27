package com.easywander.economy;

public abstract class Card extends PaymentForm{
	private String userEmail;
	private String number;
	private String owner;
	
	//setter
	public void setUserEmail(String userEmail) {this.userEmail = userEmail;}
	private void setNumber(String number) {this.number = number; }
	private void setOwner(String owner) {this.owner = owner;}
	
	//getter
	public String getUserEmail() { return userEmail; }
	public String getNumber() { return number; }
	public String getOwner() { return owner; }
	
	//constructor
	public Card(String name, String number, String expirationDate, String owner) {
		super(name,expirationDate);
		setNumber(number);
		setOwner(owner);
	}
	
	public Card(String userEmail, String name, String number, String expirationDate, String owner) {
		super(name,expirationDate);
		setUserEmail(userEmail);
		setNumber(number);
		setOwner(owner);
	}
	
}
