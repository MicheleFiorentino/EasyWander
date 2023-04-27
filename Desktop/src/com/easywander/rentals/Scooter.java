package com.easywander.rentals;

public class Scooter {
	
	private String serialNumber;
	private EnumState state;
	private EnumState stateInHub;
	private float posX;
	private float posY;
	
	//setter
	private void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	
	void setState(EnumState state) {
		this.state = state;
	}
	
	void setStateInHub(EnumState state) {
		stateInHub = state;
	}
	
	private void setPosX(float posX) { this.posX = posX; }
	private void setPosY(float posY) { this.posY = posY; }
	
	
	//getter
	public String getSerialNumber() { return serialNumber; }
	public EnumState getState() { return state; }
	public EnumState getStateInHub() { return stateInHub; }
	public float getPosX() { return posX; }
	public float getPosY() { return posY; }
	
	//constructor
	Scooter(String serialNumber, float posX, float posY){
		setSerialNumber(serialNumber);
		setState(EnumState.AVAILABLE);
		setStateInHub(EnumState.AVAILABLE);
		setPosX(posX);
		setPosY(posY);
	}
	
	
}
