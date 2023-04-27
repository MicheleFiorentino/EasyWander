package com.easywander.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.easywander.dbinterface.dbi;
import com.easywander.factory.*;
import com.easywander.people.Person;

public class SignUp {
	
	final int width = 600;
	final int height = 400;
	
	private static JLabel nameLabel;
	private static JTextField nameText;
	private static JLabel surnameLabel;
	private static JTextField surnameText;
	private static JLabel birthDateLabel;
	private static JTextField birthDateText;
	private static JLabel emailLabel;
	private static JTextField emailText;
	private static JLabel passwordLabel;
	private static JPasswordField passwordText;
	private static JLabel confirmPasswordLabel;
	private static JPasswordField confirmPasswordText;
	
	private static JLabel loginResult;
	
	private static JButton buttonSignUp;
	private static JButton buttonGoBack;
	
	public SignUp(){
		
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
		//FIELDS
		
		nameLabel = new JLabel("Name");
		nameLabel.setBounds(10, 20, 80, 25);
		panel.add(nameLabel);
		
		nameText = new JTextField(20);
		nameText.setBounds(100, 20, 165, 25);
		panel.add(nameText);
		
		surnameLabel = new JLabel("Surname");
		surnameLabel.setBounds(10, 50, 80, 25);
		panel.add(surnameLabel);
		
		surnameText = new JTextField(20);
		surnameText.setBounds(100, 50, 165, 25);
		panel.add(surnameText);
		
		birthDateLabel = new JLabel("Birth Date");
		birthDateLabel.setBounds(10, 80, 80, 25);
		panel.add(birthDateLabel);
		
		birthDateText = new JTextField(20);
		birthDateText.setBounds(100, 80, 165, 25);
		panel.add(birthDateText);
		
		emailLabel = new JLabel("Email");
		emailLabel.setBounds(10, 110, 80, 25);
		panel.add(emailLabel);
		
		emailText = new JTextField(20);
		emailText.setBounds(100, 110, 165, 25);
		panel.add(emailText);
		
		passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10, 140, 80, 25);
		panel.add(passwordLabel);
		
		passwordText = new JPasswordField();
		passwordText.setBounds(100, 140, 165, 25);
		panel.add(passwordText);
		
		confirmPasswordLabel = new JLabel("Confirm P.");
		confirmPasswordLabel.setBounds(10, 170, 80, 25);
		panel.add(confirmPasswordLabel);
		
		confirmPasswordText = new JPasswordField();
		confirmPasswordText.setBounds(100, 170, 165, 25);
		panel.add(confirmPasswordText);
		
		//END FIELDS
		
		buttonSignUp = new JButton("Sign Up");
		buttonSignUp.setBounds(130, 220, 80, 25);
		panel.add(buttonSignUp);
		
		buttonGoBack = new JButton("Back");
		buttonGoBack.setBounds(10, 300, 80, 25);
		panel.add(buttonGoBack);
		
		loginResult = new JLabel("");
		loginResult.setBounds(130, 300, 300, 25);
		panel.add(loginResult);
		
		
		
		buttonSignUp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String name = nameText.getText();
				String surname = surnameText.getText();
				String birthDate = birthDateText.getText();
				String email = emailText.getText();
				String password = passwordText.getText();
				String confirmPassword = confirmPasswordText.getText();
				
				//employee and operator have special email, so we can't use the type
				if( (email.indexOf("@easyemp") != -1) || (email.indexOf("@easyop") != -1) ){
					loginResult.setText("@easyemp or @easyop are not valid for email");
					return;
				}
				
				if(!(password.equals(confirmPassword))) {
					loginResult.setText("Passwords don't match");
					return;
				}

				
				try {
					//get connection to DB
					Connection myConn;
					myConn = DriverManager.getConnection(dbi.url,dbi.usr,dbi.pwd);
					
					//create statement
					Statement myStmt = myConn.createStatement();
	
					//Execute query
					
					ResultSet myRs;
					myRs = myStmt.executeQuery("select * from user where email='" + email + "'");
				
					if (myRs.isBeforeFirst() ) {    	//Credentials are not valid. Email already existing
					    System.out.println("Email already existing"); 
					    loginResult.setText("Email already existing");
					}
					else {
						System.out.println("Signed Up");
						
						PersonFactory.createPerson(PersonType.USER, name, surname, email, password, birthDate, null, null);
						
						frame.dispose();
						new HomeFrame();
						
						}
				
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

				
			}
			
		});
		
		
		buttonGoBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new HomeFrame();
			}
			
		});
		
		
		
		frame.setVisible(true);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
