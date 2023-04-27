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

public class Login {
	
	final int width = 600;
	final int height = 400;
	
	private static JLabel userLabel;
	private static JTextField userText;
	private static JLabel passwordLabel;
	private static JPasswordField passwordText;
	private static JButton buttonLogin;
	private static JButton buttonGoBack;
	private static JLabel loginResult;
	
	public Login() {
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
		userLabel = new JLabel("Email");
		userLabel.setBounds(10, 20, 80, 25);
		panel.add(userLabel);
		
		userText = new JTextField(20);
		userText.setBounds(100, 20, 165, 25);
		panel.add(userText);
		
		passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10, 50, 80, 25);
		panel.add(passwordLabel);
		
		passwordText = new JPasswordField();
		passwordText.setBounds(100, 50, 165, 25);
		panel.add(passwordText);
		
		buttonLogin = new JButton("Login");
		buttonLogin.setBounds(130, 100, 80, 25);
		panel.add(buttonLogin);
		
		buttonGoBack = new JButton("Back");
		buttonGoBack.setBounds(10, 300, 80, 25);
		panel.add(buttonGoBack);
		
		loginResult = new JLabel("");
		loginResult.setBounds(10, 150, 300, 25);
		panel.add(loginResult);
		
		
		buttonLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("login");
				
				String email = userText.getText();
				String password = passwordText.getText();
				String type = "";
				
				//employee and operator do have special email
				if(email.indexOf("@easyemp") != -1)
					type = "employee";
				else if(email.indexOf("@easyop") != -1 )
					type = "operator";
				else
					type = "user";
				
				try {
					//get connection to DB
					Connection myConn;
					myConn = DriverManager.getConnection(dbi.url,dbi.usr,dbi.pwd);
					
					//create statement
					Statement myStmt = myConn.createStatement();
	
					//Execute query
					
					ResultSet myRs;
					myRs = myStmt.executeQuery("select * from " + type + " where email='" + email + "' and password='" + password + "'");
				
					if (!myRs.isBeforeFirst() ) {    	//Credentials are not valid. There are no rows
					    System.out.println("No data"); 
					    loginResult.setText("Credentials are not valid");
					}
					else {
						System.out.println("Logged in");
						
						frame.dispose();
						switch(type) {
						case "user":
							new UserFrame(email);
							break;
						case "employee":
							new EmployeeFrame(email);
							break;
						case "operator":
							new OperatorFrame(email);
							break;
						}
						
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
