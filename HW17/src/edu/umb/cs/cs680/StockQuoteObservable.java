package edu.umb.cs.cs680;

import java.util.HashMap;
import java.util.Observable;

public class StockQuoteObservable extends Observable {

	private HashMap<String, Float> map = new HashMap<>();
	
	void changeQuote(String t, float q) {
		setChanged();
		map.put(t,q);
		notifyObservers(new StockEvent(t, q));
	}
		
}
