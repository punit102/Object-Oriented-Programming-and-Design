package edu.umb.cs.cs680;

public class ThereeDObserver implements StockEvObserver {

	public void updateStock(StockEvent se) {
		((StockEvent) se).getTicker();
		((StockEvent) se).getQuote();
		System.out.print("ThereeDObserver Stock Name:" + ((StockEvent) se).getTicker());
		System.out.print("\n");
		System.out.print("ThereeDObserver Stock Quote:" + ((StockEvent) se).getQuote());

	}

}
