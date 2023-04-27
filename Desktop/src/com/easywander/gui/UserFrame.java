package com.easywander.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.easywander.factory.PersonHandler;
import com.easywander.factory.PersonType;
import com.easywander.people.Person;

import javax.swing.JLabel;

public class UserFrame {
	
	final int width = 600;
	final int height = 400;
	
	private static JLabel infoLabel;
	
	private static JButton buttonCards;
	private static JButton buttonSub;
	private static JButton buttonRental;
	private static JButton buttonCredit;
	
	private static JButton buttonLogout;
	
	public UserFrame(String email) {
		
		JPanel panel = new JPanel();
		JFrame frame = new JFrame("Home");
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		panel.setBackground(Color.GREEN);
		frame.add(panel);
		
		
		panel.setLayout(null);
		
		
		
		//x,y,width,height
		
		Person usr = PersonHandler.getPerson(PersonType.USER, email);
		
		infoLabel = new JLabel(usr.getInfo());
		infoLabel.setBounds(10, 20, 500, 25);
		panel.add(infoLabel);
		
		//BUTTONS
		buttonCards = new JButton("Cards");
		buttonCards.setBounds(30, 100, 80, 100);
		panel.add(buttonCards);
		
		buttonSub = new JButton("Sub");
		buttonSub.setBounds(140, 100, 80, 100);
		panel.add(buttonSub);
		
		buttonRental = new JButton("Rental");
		buttonRental.setBounds(250, 100, 80, 100);
		panel.add(buttonRental);
		
		buttonCredit = new JButton("Credit");
		buttonCredit.setBounds(360, 100, 80, 100);
		panel.add(buttonCredit);
		
		buttonLogout = new JButton("Logout");
		buttonLogout.setBounds(10, 300, 80, 25);
		panel.add(buttonLogout);
		
		
		
		buttonLogout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new HomeFrame();
			}
			
		});
		
		
		
		frame.setVisible(true);
		
	}
	
}

















