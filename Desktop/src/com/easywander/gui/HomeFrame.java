package com.easywander.gui;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class HomeFrame {
	
	final int width = 600;
	final int height = 400;
	
	private static JButton buttonLogin;
	private static JButton buttonSignUp;
	private static JLabel titleLabel;
	
	public HomeFrame() {
		JPanel panel = new JPanel();
		JFrame frame = new JFrame("Home");
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		panel.setBackground(Color.GREEN);
		frame.add(panel);
		
		
		panel.setLayout(null);
		
		titleLabel = new JLabel("EasyWander");
		titleLabel.setBounds(250, 50, 200,100);
		panel.add(titleLabel);
		
		buttonLogin = new JButton("Login");
		buttonLogin.setBounds(150, 200, 80, 25);
		panel.add(buttonLogin);
		
		buttonSignUp = new JButton("Sign Up");
		buttonSignUp.setBounds(300, 200, 80, 25);
		panel.add(buttonSignUp);
		
		
		buttonLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("login");
				frame.dispose();
				new Login();
				
			}
			
		});
		
		buttonSignUp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("signUp");
				frame.dispose();
				new SignUp();
				
			}
			
		});
		
		
		
		
		
		
		
		frame.setVisible(true);
	}
	
}
