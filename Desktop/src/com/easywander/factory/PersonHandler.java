package com.easywander.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import com.easywander.people.*;

import com.easywander.dbinterface.dbi;

public class PersonHandler {
	
	public static Person getPerson(PersonType personType, String email) {
		
		String type;
		Person p = null;
		
		switch(personType) {
		case USER:
			type = "user";
			break;
		case EMPLOYEE:
			type = "employee";
			break;
		case OPERATOR:
			type = "operator";
			break;
		default:
			type = "";
			break;
		}
		
		try {
			//get connection to DB
			Connection myConn = DriverManager.getConnection(dbi.url,dbi.usr,dbi.pwd);
			
			//create statement
			Statement myStmt = myConn.createStatement();
			
			//Execute query
			ResultSet myRs;
			myRs = myStmt.executeQuery("select * from " + type + " where email='" + email + "'");
			
			String name="";
			String surname="";
			String mail="";
			String pwd="";
			String bdate="";
			String cell="";
			String fiscalCode="";
			float credit = 0.0f;
			
			//get person. I create a new person based on the data retrieved and I return him
			switch(personType) {
			case USER:
				while(myRs.next()) {
					name = myRs.getString("name");
					surname = myRs.getString("surname");
					mail = myRs.getString("email");
					pwd = myRs.getString("password");
					bdate = myRs.getString("birth_date");
					credit = myRs.getFloat("credit");
				}
				p = new User(name, surname, mail, pwd, bdate, credit);
				break;
			case EMPLOYEE:
				while(myRs.next()) {
					name = myRs.getString("name");
					surname = myRs.getString("surname");
					mail = myRs.getString("email");
					pwd = myRs.getString("password");
					bdate = myRs.getString("birth_date");
					cell = myRs.getString("cell");
					fiscalCode = myRs.getString("fiscal_code");
				}
				p = new Employee(name,surname,mail,pwd,bdate,cell,fiscalCode);
				break;
			case OPERATOR:
				while(myRs.next()) {
					name = myRs.getString("name");
					surname = myRs.getString("surname");
					mail = myRs.getString("email");
					pwd = myRs.getString("password");
					bdate = myRs.getString("birth_date");
					credit = myRs.getFloat("credit");
					cell = myRs.getString("cell");
					fiscalCode = myRs.getString("fiscal_code");
				}
				p = new Operator(name,surname,mail,pwd,bdate,cell,fiscalCode);
				break;
			}
			
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
		
		return p;
		
	}
	
	
	public static void removePerson(PersonType personType, String email) {
		
		String sql;
		String type;
		
		switch(personType) {
		case USER:
			type = "user";
			break;
		case EMPLOYEE:
			type = "employee";
			break;
		case OPERATOR:
			type = "operator";
			break;
		default:
			type = "";
			break;
		}
		
		try {
			//get connection to DB
			Connection myConn = DriverManager.getConnection(dbi.url,dbi.usr,dbi.pwd);
			
			//create statement
			Statement myStmt = myConn.createStatement();
			
			//Execute query
			sql = "delete from " + type + " where email='" + email + "';";
			myStmt.executeUpdate(sql);
			System.out.println("Removal complete.\n\n");
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
		
	}
	
}
