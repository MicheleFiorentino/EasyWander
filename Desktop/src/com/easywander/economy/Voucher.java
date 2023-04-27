package com.easywander.economy;

public class Voucher extends PaymentForm{
	
	private float value;
	
	//setter
	private void setValue(float value) { this.value = value; }
	
	//getter
	public float getValue() { return value; }
	
	//constructor
	public Voucher(String name, String expirationDate, float value) {
		super(name, expirationDate);
		setValue(value);
	}
	
}
