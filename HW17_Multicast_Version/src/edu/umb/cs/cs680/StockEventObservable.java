package edu.umb.cs.cs680;

import java.util.ArrayList;

public class StockEventObservable {

	private ArrayList<StockEvObserver> seo = new ArrayList<StockEvObserver>();
	void addEventListner(StockEvObserver el) {
		seo.add(el);
	}

	void notifyObservers(StockEvent ev) {
		for (StockEvObserver observer1 : seo) {
			
				observer1.updateStock(ev);
		}
	}

}
