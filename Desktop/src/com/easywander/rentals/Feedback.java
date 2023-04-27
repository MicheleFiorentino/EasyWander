package com.easywander.rentals;

public class Feedback {
	private String userEmail;
	private String scooterSerialNumber;
	private String date;
	private boolean review; //like or dislike
	
	//setter
	private void setUserEmail(String userEmail) { this.userEmail = userEmail; }
	private void setScooterSerialNumber(String ssn) { scooterSerialNumber = ssn; }
	private void setDate(String date) { this.date = date; }
	private void setReview(boolean review) { this.review = review; }
	
	//getter
	public String getUserEmail() { return userEmail; }
	public String getScooterSerialNumber() { return scooterSerialNumber; }
	public String getDate() { return date; }
	public boolean getReview() { return review; }
	
	//constructor
	Feedback(String userEmail, String ssn, String date, boolean review){
		setUserEmail(userEmail);
		setScooterSerialNumber(ssn);
		setDate(date);
		setReview(review);
	}
	
}
