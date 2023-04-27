package com.easywander.people;
import com.easywander.rentals.*;
import java.util.ArrayList;

public class Operator extends Person {
	
	private String cell;
	private String fiscalCode;
	private ArrayList<Scooter> scooters = new ArrayList<Scooter>();
	
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
	
	public ArrayList<Scooter> getScootersToHandle(){
		return scooters;//**
	}
	
	@Override
	public String getInfo() {
		String info = getName() + " " + getSurname() + ", " + getEmail() + ", " + getBirthDate() + ", " +  getCell() + ", " + getFiscalCode() + "\n";
		return info;
	}
	
	//constructor
	public Operator(String name, String surname, String email,  String password, String birthDate, String cell, String fiscalCode){
		super(name,surname,email, password, birthDate);
		setCell(cell);
		setFiscalCode(fiscalCode);
	}
	
	
	//methods
	
	public void pickupScooter(String serialNumber) {
		//**
	}
	
	public void putbackScooter(String serialNumber) {
		//**
	}
	
}
