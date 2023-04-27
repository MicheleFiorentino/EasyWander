package com.easywander.paymentstrategy;
import com.easywander.economy.CreditCard;

public class CreditCardStrategy implements PaymentStrategy{
	
	private CreditCard card;
	
	public CreditCardStrategy(CreditCard card) {
		this.card = card;
	}
	
	@Override
	public float pay(float amount) {
		System.out.println(amount + "paid with Credit Card: " + card.getName());
		return amount;
	}
	
}
