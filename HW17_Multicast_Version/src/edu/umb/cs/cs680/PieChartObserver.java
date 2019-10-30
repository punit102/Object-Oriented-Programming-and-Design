package edu.umb.cs.cs680;

public class PieChartObserver implements StockEvObserver {

	public void updateStock(StockEvent se) {
		((StockEvent) se).getTicker();
		((StockEvent) se).getQuote();
		System.out.print("PieChartObserver Stock Name:" + ((StockEvent) se).getTicker());
		System.out.print("\n");
		System.out.print("PieChartObserver Stock Quote:" + ((StockEvent) se).getQuote());
	}
}
