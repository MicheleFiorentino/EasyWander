package com.easywander.people;
import com.easywander.economy.*;
import com.easywander.rentals.*;
import com.easywander.handlerental.*;
import com.easywander.paymentstrategy.*;
import com.easywander.dbinterface.dbi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class User extends Person{
	
	//Setup Chain of Responsibility
	RentHandler h1 = new ScooterNotExistingRentHandler();
	RentHandler h2 = new AvailableRentHandler();
	RentHandler h3 = new NotAvailableRentHandler();
	private boolean isChainSet = false;
	private void setChain() {
		h1.setSuccessor(h2);
		h2.setSuccessor(h3);
	}
	
	
	//Class
	
	private Credit credit = new Credit();
	private ArrayList<Card> cards = new ArrayList<Card>();
	private Subscription sub;
	private History history;
	
	//setter
	
	public void setCredit(float value) {
		credit.setValue(value);
	}
	
	public void setSubscription(String name, float cost) {
		sub = new Subscription(name,cost);
	}
	
	//getter
	public float getCreditValue() { return credit.getValue(); }
	
	
	public ArrayList<Card> getCards() { 
		
		//get cards from DB
		
		try {
			//Connection to DB and Creation of Statement
			Connection myConn = DriverManager.getConnection(dbi.url,dbi.usr,dbi.pwd);
			Statement myStmt = myConn.createStatement();
			
			//get rows
			ResultSet myRs;
			
			myRs = myStmt.executeQuery("select * from credit_card where user_email='" + getEmail() + "'");
			while(myRs.next()) {
				cards.add(new CreditCard(myRs.getString("user_email"),myRs.getString("name"), myRs.getString("number"),myRs.getString("expiration_date"),myRs.getString("owner")));
			}
			
			myRs = myStmt.executeQuery("select * from debit_card where user_email='" + getEmail() + "'");
			while(myRs.next()) {
				cards.add(new DebitCard(myRs.getString("user_email"),myRs.getString("name"), myRs.getString("number"),myRs.getString("expiration_date"),myRs.getString("owner")));
			}
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		
		return cards; 
	}
	
	@Override
	public String getInfo() {
		String info = getName() + " " + getSurname() + ", " + getEmail() + ", " + getBirthDate() + ", " +  String.valueOf(getCreditValue()) + "\n";
		return info;
	}
	
	
	public Subscription getSubscription() { return sub; }
	public History getHistory() { return history; }
	
	//constructor
	public User(String name, String surname, String email, String password, String birthDate){
		super(name,surname,email,password, birthDate);
		setCredit(0.0f);
	}
	
	public User(String name, String surname, String email, String password, String birthDate, float credit){
		super(name,surname,email,password, birthDate);
		setCredit(credit);
	}
	
	
	//methods
	
	
	/// ADD and REMOVE CARD methods
	
	public void addCard(Card newCard) {
		
		//add to DB
		try {
			
			//Connection to DB and Creation of Statement
			Connection myConn = DriverManager.getConnection(dbi.url,dbi.usr,dbi.pwd);
			Statement myStmt = myConn.createStatement();
			
			String cardClassName = newCard.getClass().getSimpleName();
			String sql = "";
			
			newCard.setUserEmail(getEmail()); 				//email è un valore che già abbiamo nella classe, quindi è inutile ripassarlo in newCard
			if(cardClassName.equals("CreditCard")) {
				sql = "insert into credit_card (number,user_email, name,expiration_date,owner) "
						+ "values ('" + newCard.getNumber() + "', "
								+ "'" + newCard.getUserEmail() +"', "
								+ "'" + newCard.getName() +"', "
								+ "'" + newCard.getExpirationDate() +"', "
								+ "'" + newCard.getOwner() +"'); ";
								
			} else if(cardClassName.equals("DebitCard")) {
				sql = "insert into debit_card (number,user_email, name,expiration_date,owner) "
						+ "values ('" + newCard.getNumber() + "', "
								+ "'" + newCard.getUserEmail() +"', "
								+ "'" + newCard.getName() +"', "
								+ "'" + newCard.getExpirationDate() +"', "
								+ "'" + newCard.getOwner() +"'); ";
			}
			
			myStmt.executeUpdate(sql);
			System.out.println(cardClassName + " added.\n\n");
			
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
		
	}
	
	public void removeCard(String cardNumber) {
		
		String sql = "";
		try {
			//Connection to DB and Creation of Statement
			Connection myConn = DriverManager.getConnection(dbi.url,dbi.usr,dbi.pwd);
			Statement myStmt = myConn.createStatement();
			
			//identify the card type through ResultSet
			String temp = "";
			
			ResultSet myRs = myStmt.executeQuery("select * from credit_card where number='" + cardNumber + "' and user_email='"+ getEmail() +"';");
			while(myRs.next()) {
				temp = myRs.getString("number");
			}
				
			
			//Execute query
			if(!temp.equals("")) { //it is a credit card
				sql = "delete from credit_card where number='" + cardNumber + "' and user_email='"+ getEmail() +"';";
				myStmt.executeUpdate(sql);
				System.out.println("Credit Card removal complete.\n\n");
			} else {
				sql = "delete from debit_card where number='" + cardNumber + "' and user_email='"+ getEmail() +"';";
				myStmt.executeUpdate(sql);
				System.out.println("Debit Card removal complete.\n\n");
			}
			
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
	}
	
	
	
	/// ADD RENTAL method
	
	public void newRental(RentRequest request) {
		if(!isChainSet) {
			setChain();
			isChainSet = true;
		}
		
		h1.handleRequest(request);
		
	}
	
	
	/// ADD and REMOVE CREDIT methods
	
	public void addCredit(PaymentStrategy PaymentForm, float value) {
		credit.addCredit(PaymentForm, value);
	}
	
	public void removeCredit(float value) {
		credit.removeCredit(value);
	}
	
}
