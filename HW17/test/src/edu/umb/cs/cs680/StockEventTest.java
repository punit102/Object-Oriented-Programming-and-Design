package edu.umb.cs.cs680;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class StockEventTest {

	
	// This is StockEvent getTicker value testing 
	@Test
	public void testStockEvent_Get_Ticker() {

		StockEvent se = new StockEvent("Google",212.00f);
		String expected = "Google";
		String actual = se.getTicker();
		assertThat(actual, is(expected));
	}
	
	// This is StockEvent getTQuote value testing 
	@Test
	public void testStockEvent_Get_Quote() {

		StockEvent se = new StockEvent("Google",212.00f);
		float expected = 212.00f;
		float actual = se.getQuote();
		assertThat(actual, is(expected));
	}

}
