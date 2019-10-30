package edu.umb.cs.cs680;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ThereeDObserverTest {

	
	
	/*
	 * 
	 * 
	 * This is ThereeDObserver update method testing. Here I used
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
	 * For the testing ThreeDObserver update method purpose I took two different Ticker Value and Quote value.	
	 * And with the given value
	*/
	
	@Test
	public void testThreeDObserver_update() {

		StockQuoteObservable sqo = new StockQuoteObservable();
		ThereeDObserver tdo = new ThereeDObserver();
		sqo.addObserver(tdo);
		sqo.changeQuote("uber", 212.00f);
		sqo.changeQuote("Amazon", 111.00f);
		assertEquals(
				"ThreeDObserver Stock Ticker:uberThreeDObserver Stock Quote:212.0ThreeDObserver Stock Ticker:AmazonThreeDObserver Stock Quote:111.0",
				outContent.toString());

	}
}
