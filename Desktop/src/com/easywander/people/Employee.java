package com.easywander.people;
import java.util.ArrayList;

import com.easywander.rentals.*;

public class Employee extends Person {
	
	private String cell;
	private String fiscalCode;
	
	//setter
	public void setCell(String cell) {
		this.cell = cell;
	}
	
	public void setFiscalCode(String fiscalCode) {
		if(fiscalCode.length() != 11) {
			System.err.println("FiscalCode has 11 characters, \"null\" is inserted instead");
			fiscalCode = null;
		}
		
		this.fiscalCode = fiscalCode;
	}
	
	
	//getter
	public String getCell() { return cell; }
	public String getFiscalCode() { return fiscalCode; }
	
	
	public User getClientInfo(String userEmail) {
		return null; //**
	}
	
	public History getClientHistory(String userEmail) {
		return null; //**
	}
	
	public ArrayList<Feedback> getClientFeedbacks(){
		return null; //**
	}
	
	public Operator getOperatorInfo(String opEmail) {
		return null; //**
	}
	
	@Override
	public String getInfo() {
		String info = getName() + " " + getSurname() + ", " + getEmail() + ", " + getBirthDate() + ", " +  getCell() + ", " + getFiscalCode() + "\n";
		return info;
	}
	
	
	//constructor
	public Employee(String name, String surname, String email,  String password, String birthDate, String cell, String fiscalCode){
		super(name,surname,email,password, birthDate);
		setCell(cell);
		setFiscalCode(fiscalCode);
	}
	
	
	//methods
	
	public void addScooter(Scooter scooter) {
		//**
	}
	
	public void removeScooter(String serialNumber) {
		//**
	}
	
	public void addHub(Hub hub) {
		//**
	}
	
	public void removeHub(String name) {
		//**
	}
	
	
	public void disableScooter(String serialNumber) {
		//**
	}
	
	public void assignScooterToOperator(String OpEmail, String serialNumber) {
		//**
	}
	
	public void removeScooterFromOperator(String OpEmail, String serialNumber) {
		//**
	}
}













