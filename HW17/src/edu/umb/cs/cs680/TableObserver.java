package edu.umb.cs.cs680;

import java.util.Observable;
import java.util.Observer;

public class TableObserver implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		((StockEvent) arg).getTicker();
		((StockEvent) arg).getQuote();
		System.out.print("TableObserver Stock Ticker:"+((StockEvent) arg).getTicker());
		System.out.print("TableObserver Stock Quote:"+((StockEvent) arg).getQuote());
	}

}