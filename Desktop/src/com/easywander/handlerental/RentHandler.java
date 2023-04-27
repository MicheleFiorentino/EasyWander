package com.easywander.handlerental;

public abstract class RentHandler {
	
	protected RentHandler successor;
	
	public void setSuccessor(RentHandler successor) {
		this.successor = successor;
	}
	
	public abstract void handleRequest(RentRequest request);
	
}
