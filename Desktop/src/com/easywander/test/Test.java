package com.easywander.test;
import java.sql.*;
import com.easywander.factory.PersonHandler;
import com.easywander.factory.PersonType;
import com.easywander.people.*;

public class Test {
	public static void main(String[] args) {
		
		Person p = PersonHandler.getPerson(PersonType.USER, "mariabossi@gmail.it");
		
		System.out.println(p.getInfo());

	}
}
