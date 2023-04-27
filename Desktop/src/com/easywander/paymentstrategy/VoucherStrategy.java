package com.easywander.paymentstrategy;
import com.easywander.economy.Voucher;

public class VoucherStrategy implements PaymentStrategy{
	
	private Voucher voucher;
	
	public VoucherStrategy(Voucher voucher) {
		this.voucher = voucher;
	}
	
	@Override
	public float pay(float amount) {
		System.out.println(voucher.getValue() + "paid with Voucher: " + voucher.getName());
		return voucher.getValue();
	}
	
}
