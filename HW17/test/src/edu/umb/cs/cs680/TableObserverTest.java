package edu.umb.cs.cs680;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TableObserverTest {

	/*
	 * 
	 * 
	 * This is TableObserver update method testing. Here I used
	 * System.out.print() -> testing which compare the void method
	 * System.out.print() output with the mine given output. For the testing
	 * purpose I took two different Ticker Value and Quote value
	 * 
	 */
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
	}

	@After
	public void cleanUpStreams() {
		System.setOut(null);
		System.setErr(null);
	}

	/*
	 * 
	 *
	 * For the testing TableObserver update method purpose I took two different Ticker Value and Quote value.	
	 * And with the given value
	*/
	
	@Test
	public void testTableObserver_update() {

		StockQuoteObservable sqo = new StockQuoteObservable();
		TableObserver to = new TableObserver();
		sqo.addObserver(to);
		sqo.changeQuote("uber", 212.00f);
		sqo.changeQuote("Amazon", 111.00f);
		assertEquals(
				"TableObserver Stock Ticker:uberTableObserver Stock Quote:212.0TableObserver Stock Ticker:AmazonTableObserver Stock Quote:111.0",
				outContent.toString());

	}

}
