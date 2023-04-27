package com.easywander.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.easywander.factory.PersonHandler;
import com.easywander.factory.PersonType;
import com.easywander.people.Person;

public class EmployeeFrame {
	
	final int width = 600;
	final int height = 400;
	
	private static JLabel infoLabel;
	
	private static JButton buttonUsers;
	private static JButton buttonScooters;
	private static JButton buttonHubs;
	
	private static JButton buttonLogout;
	
	public EmployeeFrame(String email) {
		
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
		
		Person emp = PersonHandler.getPerson(PersonType.EMPLOYEE, email);
		
		infoLabel = new JLabel(emp.getInfo());
		infoLabel.setBounds(10, 20, 500, 25);
		panel.add(infoLabel);
		
		//BUTTONS
		buttonUsers = new JButton("Users");
		buttonUsers.setBounds(30, 100, 80, 150);
		panel.add(buttonUsers);
		
		buttonScooters = new JButton("Scooters");
		buttonScooters.setBounds(190, 100, 80, 150);
		panel.add(buttonScooters);
		
		buttonHubs = new JButton("Hubs");
		buttonHubs.setBounds(350, 100, 80, 100);
		panel.add(buttonHubs);
		
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
