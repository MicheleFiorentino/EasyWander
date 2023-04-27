package com.easywander.creditmemento;

public class Caretaker {
	
	Memento oldValue;
	
	//setter
	public void setMemento(Memento memento) {
		oldValue = memento;
	}
	
	//getter
	public Memento getMemento() {
		return oldValue;
	}
	
}
