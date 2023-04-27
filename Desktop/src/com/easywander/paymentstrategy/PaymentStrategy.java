package com.easywander.paymentstrategy;

public interface PaymentStrategy {
	
	//effective payment (this for Voucher)
	public float pay(float amount);
	
	
}