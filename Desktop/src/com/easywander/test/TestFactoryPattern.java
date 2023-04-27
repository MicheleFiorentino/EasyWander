package com.easywander.test;
import com.easywander.people.*;
import com.easywander.factory.*;

public class TestFactoryPattern {

	public static void main(String[] args) {
		
		
		Person usr = PersonFactory.createPerson(PersonType.USER, "Mario", "Rossi", "mariorossi@gmail.it", "pwd1", "10-10-1990", null, null);
		
		Person emp = PersonFactory.createPerson(PersonType.EMPLOYEE, "Luigi", "Verdi", "luigiverdi@easyemp.it", "pwd2", "05-03-1994", "1234567890", "aaaaaaaaaaa");
		
		Person op = PersonFactory.createPerson(PersonType.OPERATOR, "Marco", "Gialli", "marcogialli@easyop.it", "pwd3", "01-02-2001", "1234567899", "aaaaaaaaaab");
		
		
		//PersonHandler.removePerson(PersonType.OPERATOR, "marcogialli@gmail.it");
		
		//Person p = PersonHandler.getPerson(PersonType.USER, "mariabossi@gmail.it");
		
		System.out.println(usr.getInfo() + "\n" + emp.getInfo() + "\n" + op.getInfo() );
		
		
	}

}
