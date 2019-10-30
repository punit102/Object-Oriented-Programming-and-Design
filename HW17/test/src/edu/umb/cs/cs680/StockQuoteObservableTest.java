package edu.umb.cs.cs680;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StockQuoteObservableTest {
	
	/*	
	 * This is StockQuoteObservable changeQuota method testing.
	 * Here I used System.out.print() -> testing which compare the void method System.out.print() output with the mine given output. 
	 * For the testing purpose I add three Observers and then test with two different Ticker and Quote value
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
 	 *For the testing StockQuoteObservable changeQuota method purpose I took two different Ticker Value and Quote value.	
	 * And with the given value
	 * 
	 * 
	*/
	@Test
	public void testchangeQuote() {

		StockQuoteObservable sqo = new StockQuoteObservable();
		TableObserver to = new TableObserver();
		PieChartObserver pco = new PieChartObserver();
		ThereeDObserver tdo = new ThereeDObserver();
		sqo.addObserver(to);
		sqo.addObserver(pco);
		sqo.addObserver(tdo);
		sqo.changeQuote("uber", 212.00f);
		sqo.changeQuote("Amazon", 111.00f);
		String expected = "ThreeDObserver Stock Ticker:uberThreeDObserver Stock Quote:212.0PieChartObserver Stock Quote:212.0PieChartObserver Stock Ticker:uberTableObserver Stock Ticker:uberTableObserver Stock Quote:212.0ThreeDObserver Stock Ticker:AmazonThreeDObserver Stock Quote:111.0PieChartObserver Stock Quote:111.0PieChartObserver Stock Ticker:AmazonTableObserver Stock Ticker:AmazonTableObserver Stock Quote:111.0";
		String actual = outContent.toString();
		assertThat(actual, is(expected));
	}

}
