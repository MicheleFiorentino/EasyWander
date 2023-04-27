package com.easywander.people;

public abstract class Person {
	
	protected String name;
	protected String surname;
	protected String email;
	protected String password;
	protected String birthDate;
	
	//setter
	public void setName(String name) { this.name=name; }
	public void setSurname (String surname) { this.surname=surname; }
	public void setEmail(String email) { this.email=email; }
	public void setPassword(String password) {this.password = password; }
	public void setBirthDate(String birthDate) { this.birthDate=birthDate; }
	
	//getter
	public String getName() { return name; }
	public String getSurname() { return surname; }
	public String getEmail() { return email; }
	public String getBirthDate() { return birthDate; }
	public abstract String getInfo();
	
	//constructor for child classes
	public Person (String name, String surname, String email, String password, String birthDate) {
		setName(name);
		setSurname(surname);
		setEmail(email);
		setPassword(password);
		setBirthDate(birthDate);
	}
	
	//methods
	
	public void getScootersInRange() {} //definire meglio...
	
}