package com.easywander.paymentstrategy;
import com.easywander.economy.DebitCard;

public class DebitCardStrategy implements PaymentStrategy{
	
	private DebitCard card;
	
	public DebitCardStrategy(DebitCard card) {
		this.card = card;
	}
	
	@Override
	public float pay(float amount) {
		System.out.println(amount + "paid with Debit Card: " + card.getName());
		return amount;
	}
	
}
