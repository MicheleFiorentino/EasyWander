package com.easywander.economy;
import com.easywander.paymentstrategy.PaymentStrategy;
import com.easywander.creditmemento.*;

public class Credit {
	
	private float value = 0;
	
	//setter
	
	public void setValue(float value) {
		this.value = value;
	}
	
	//getter
	public float getValue() { return value; }
	
	
	//constructor
	
	
	//methods
	
	public Memento storeInMemento() {
		return new Memento(value);
	}
	
	public float restoreFromMemento(Memento memento) {
		value = memento.getSavedValue();
		return value;
	}
	
	//with TopUpStrategy I'll have to pass a card 'cause the constr.
	//or the Vaucher, in this case quantity = null
	
	public void addCredit(PaymentStrategy paymentMethod, float quantity) {
		float effectiveQuantity = paymentMethod.pay(quantity);
		setValue( getValue() + effectiveQuantity );
	}
	
	public void removeCredit(float quantity) {
		setValue( getValue() - quantity);
	}
}
