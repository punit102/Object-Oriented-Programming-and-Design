package edu.umb.cs.cs680;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StockEventObservableTest {

	/*	
	 * This is StockEventObservable changeQuota method testing.
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
 	 *For the testing StockEventObservable NotifyObservers method purpose I took two different Ticker Value and Quote value.	
	 * And with the given value
	 * 
	 * 
	*/
	@Test
	public void testNotifyObservers() {
		
		StockEventObservable seo = new StockEventObservable();
		TableObserver to = new TableObserver();
		PieChartObserver pco = new PieChartObserver();
		ThereeDObserver tdo = new ThereeDObserver();
		seo.addEventListner(to);
		seo.addEventListner(tdo);
		seo.addEventListner(pco);
		seo.notifyObservers(new StockEvent("ABC",100.0f));
		seo.notifyObservers(new StockEvent("ABC",111.00f));
		String expected = "TableObserver Stock Name:ABC\nTableObserver Stock Quote:100.0ThereeDObserver Stock Name:ABC\nThereeDObserver Stock Quote:100.0PieChartObserver Stock Name:ABC\nPieChartObserver Stock Quote:100.0TableObserver Stock Name:ABC\nTableObserver Stock Quote:111.0ThereeDObserver Stock Name:ABC\nThereeDObserver Stock Quote:111.0PieChartObserver Stock Name:ABC\nPieChartObserver Stock Quote:111.0";
		String actual = outContent.toString();
		assertThat(actual, is(expected));

	}

}
