package edu.umb.cs.cs680;

public class StockEvent extends EventObject {

	private String ticker;
	private float quote;
	private static StockEvent se;
	
	StockEvent(String t, float q) {	
		super(getStockEventObject());
		this.ticker = t;
		this.quote = q;
	}

	public String getTicker() {
		return ticker;	
	}
	public float getQuote() {
		return quote;
	}
	
	public static StockEvent getStockEventObject()
	{
		return se;
	}

}
