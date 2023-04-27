package com.easywander.rentals;
import java.util.ArrayList;
import java.util.Iterator;

public class Hub {
	
	private String name;
	private float posX;
	private float posY;
	private ArrayList<Scooter> scooters = new ArrayList<Scooter>();
	private Iterator<Scooter> its = scooters.iterator();
	
	
	//setter
	private void setName(String name) { this.name = name; }
	private void setPosX(float posX) { this.posX = posX; }
	private void setPosY(float posY) { this.posY = posY; }
	
	//getter
	public String getName() { return name; }
	public float getPosX() { return posX; }
	public float getPosY() { return posY; }
	
	//constructor
	Hub(String name, float posX, float posY){
		setName(name);
		setPosX(posX);
		setPosY(posY);
	}
	
	
	//methods
	public void addScooter(Scooter newScooter) {
		scooters.add(newScooter);
	}
	
	
	public boolean removeScooter(String scooterSerialNumber) {
			
		while(its.hasNext()) {
			if(its.next().getSerialNumber() == scooterSerialNumber) {
				its.remove();
				return true;
			}
		}
		
		return false;
	}
	
	
}
