package com.easywander.handlerental;

import java.util.ArrayList;
import java.util.Iterator;

import com.easywander.rentals.EnumState;
import com.easywander.rentals.Scooter;

public class NotAvailableRentHandler extends RentHandler{
	
	protected ArrayList<Scooter> scooters = new ArrayList<Scooter>();
	protected Iterator<Scooter> its = scooters.iterator();
	
	private void getScootersFromDB() {
		//**
	}
	
	public void handleRequest(RentRequest request) {
		
		Scooter temp;
		getScootersFromDB();
		
		boolean result = false;
		while(its.hasNext()) {
			temp = its.next();
			if(temp.getSerialNumber().equals(request.getScooterSerialNumber())) {
				if(temp.getState() == EnumState.NOT_AVAILABLE)
					result = true;
			}
		}
		
		if(result) {	//It is NOT AVAILABLE
			
		}
		else {	//It is
			successor.handleRequest(request);
		}
		
	}
	
}
