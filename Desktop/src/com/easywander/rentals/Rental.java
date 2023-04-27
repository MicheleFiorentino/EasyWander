package com.easywander.rentals;

public class Rental {
	
	private String userEmail;
	private float rentalTime;
	private Scooter rentedScooter;
	
	//setter
	private void setUserEmail(String userEmail) { this.userEmail = userEmail; }
	private void setRentalTime(float rentalTime) { this.rentalTime = rentalTime;}
	private void setRentedScooter(Scooter rentedScooter) {
		this.rentedScooter = rentedScooter;
	}
	
	//getter
	public String getUserEmail() { return userEmail; }
	public float getRentalTime() { return rentalTime; }
	public Scooter getRentedScooter() { return rentedScooter; }
	public EnumState getRentedScooterState() { return rentedScooter.getState(); }
	
	
	//constructor
	public Rental(String userEmail, Scooter rentedScooter,float rentalTime) {
		setUserEmail(userEmail);
		setRentalTime(rentalTime);
		setRentedScooter(rentedScooter);
	}
	
}
