package com.easywander.handlerental;
import java.util.ArrayList;
import java.util.Iterator;
import com.easywander.rentals.Scooter;

public class ScooterNotExistingRentHandler extends RentHandler{
	
	protected ArrayList<Scooter> scooters = new ArrayList<Scooter>();
	protected Iterator<Scooter> its = scooters.iterator();
	
	
	private void getScootersFromDB() {
		//**
	}
	
	public void handleRequest(RentRequest request) {
		
		getScootersFromDB();
		
		boolean result = true;
		while(its.hasNext()) {
			if(its.next().getSerialNumber().equals(request.getScooterSerialNumber())) {
				result = false;
			}
		}
		
		if(result) {	//It does NOT exists
			
		}
		else {	//It DOES exists
			successor.handleRequest(request);
		}
	}
	
}
