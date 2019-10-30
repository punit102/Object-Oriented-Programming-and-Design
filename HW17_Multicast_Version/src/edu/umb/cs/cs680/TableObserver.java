package edu.umb.cs.cs680;

public class TableObserver implements StockEvObserver {

	public void updateStock(StockEvent se) {
		((StockEvent) se).getTicker();
		((StockEvent) se).getQuote();
		System.out.print("TableObserver Stock Name:"+((StockEvent) se).getTicker());
		System.out.print("\n");
		System.out.print("TableObserver Stock Quote:"+((StockEvent) se).getQuote());
		
	}

}
