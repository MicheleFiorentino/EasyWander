package com.easywander.economy;

public abstract class PaymentForm {
	private String name;
	private String expirationDate;
	
	//setter
	private void setName(String name) { this.name = name; }
	private void setExpirationDate(String expirationDate) {this.expirationDate = expirationDate;}
	
	//getter
	public String getName() { return name; }
	public String getExpirationDate() { return expirationDate; }
	
	//constructor
	public PaymentForm(String name, String expirationDate) {
		setName(name);
		setExpirationDate(expirationDate);
	}
	
}
