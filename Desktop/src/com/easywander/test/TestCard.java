package com.easywander.test;
import com.easywander.people.*;
import com.easywander.factory.*;
import com.easywander.economy.*;
import java.util.ArrayList;
import java.util.Iterator;

public class TestCard {
	public static void main(String[] args) {
		
		Person usr = PersonFactory.createPerson(PersonType.USER, "Maria", "Bossi", "mariabossi@gmail.it", "pwd1", "10-10-1990", null, null);
		User user = (User)usr;
		
		user.addCard(new CreditCard("VISA", "1111222233334444", "05-08-2025", "Maria Bossi"));
		user.addCard(new DebitCard("VISA", "1111222233334445", "05-08-2025", "Maria Bossi"));
		
		user.removeCard("1111222233334444");
		
		ArrayList<Card> cards = user.getCards();
		Iterator<Card> itc = cards.iterator();
		
		while(itc.hasNext()) {
			System.out.println(itc.next().getNumber() + "\n");
		}
		
		
	}
}
