package edu.umb.cs.cs680;

import java.util.Observable;
import java.util.Observer;

public class PieChartObserver implements Observer {

	public void update(Observable o, Object arg) {
		((StockEvent) arg).getTicker();
		((StockEvent) arg).getQuote();
		System.out.print("PieChartObserver Stock Quote:"+((StockEvent) arg).getQuote());
		System.out.print("PieChartObserver Stock Ticker:"+((StockEvent) arg).getTicker());
	}
	
}
