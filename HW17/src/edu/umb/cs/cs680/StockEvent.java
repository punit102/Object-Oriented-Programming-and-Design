package edu.umb.cs.cs680;

public class StockEvent {

	private String ticker;
	private float quote;


	StockEvent(String t, float q) {
		this.ticker = t;
		this.quote = q;
	}

	public String getTicker() {
		return ticker;	
	}

	public float getQuote() {
		return quote;
	}

}
