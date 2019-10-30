package edu.umb.cs.cs680;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PieChartObserverTest {

	/*
	 * 
	 * 
	 * This is PieChartObserver update method testing. Here I used
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
	 * For the testing PieChartObserver updateStock method purpose I took two different Ticker Value and Quote value.	
	 * And with the given value
	*/
	@Test
	public void testPieChartObserver_UpdateStock() {

		StockEventObservable seo = new StockEventObservable();
		PieChartObserver pco = new PieChartObserver();
		seo.addEventListner(pco);
		seo.notifyObservers(new StockEvent("ABC", 100f));
		seo.notifyObservers(new StockEvent("Amazon", 111.00f));
		String expected = "PieChartObserver Stock Name:ABC\nPieChartObserver Stock Quote:100.0PieChartObserver Stock Name:Amazon\nPieChartObserver Stock Quote:111.0";
		String actual = outContent.toString();
		assertThat(actual, is(expected));
	}

}
