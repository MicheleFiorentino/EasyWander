package com.easywander.handlerental;

public class RentRequest {
	private String scooterSerialNumber;
	
	//setter
	private void setScooterSerialNumber(String scooterSerialNumber) {
		this.scooterSerialNumber = scooterSerialNumber;
	}
	
	//getter
	String getScooterSerialNumber() {
		return scooterSerialNumber;
	}
	
	//constructor
	public RentRequest(String scooterSerialNumber) {
		setScooterSerialNumber(scooterSerialNumber);
	}
}
