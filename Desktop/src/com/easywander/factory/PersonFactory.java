package com.easywander.factory;
import com.easywander.people.*;

import java.sql.*;

import com.easywander.dbinterface.dbi;

public class PersonFactory {
	
	public static Person createPerson(PersonType type, String name, String surname, String email, 
			String password, String birthDate, String cell, String fiscalCode) {
		
		Person p = null;
		String sql;
		
		try {
			
			//get connection to DB
			Connection myConn = DriverManager.getConnection(dbi.url,dbi.usr,dbi.pwd);
			
			//create statement
			Statement myStmt = myConn.createStatement();
			
			
			//Will execute an SQL query to insert the right kind of person
			
			switch(type) {
			case USER:
				p = new User(name, surname, email, password, birthDate);
				sql = "insert into user (name, surname, email, password,birth_date,credit) "
						+ "values ('" + name + "', "
								+ "'" + surname + "', "
								+ "'" + email + "', "
								+ "'" + password + "', "
								+ "'" + birthDate + "', "
								+ " 0.0);"; 				//credit
				break;
			case EMPLOYEE:
				p = new Employee(name, surname, email, password, birthDate, cell, fiscalCode);
				sql = "insert into employee (name, surname, email, password,birth_date, cell, fiscal_code) "
						+ "values ('" + name + "', "
								+ "'" + surname + "', "
								+ "'" + email + "', "
								+ "'" + password + "', "
								+ "'" + birthDate + "', "
								+ "'" + cell + "', "
								+ "'" + fiscalCode + "'); ";
				break;
			case OPERATOR:
				p = new Operator(name, surname, email, password, birthDate, cell, fiscalCode);
				sql = "insert into operator (name, surname, email, password,birth_date, cell, fiscal_code) "
						+ "values ('" + name + "', "
								+ "'" + surname + "', "
								+ "'" + email + "', "
								+ "'" + password + "', "
								+ "'" + birthDate + "', "
								+ "'" + cell + "', "
								+ "'" + fiscalCode + "'); ";
				break;
			default:
				//invalid
				return p;
			}
			
			myStmt.executeUpdate(sql);
			System.out.println("Insert complete.\n\n");
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		
	
		
		return p;
		
	}
	
}