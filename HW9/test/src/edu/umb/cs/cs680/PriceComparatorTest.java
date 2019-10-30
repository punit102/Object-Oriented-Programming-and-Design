package edu.umb.cs.cs680;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

public class PriceComparatorTest {

	
	/*
	 * 
	 * 
	 * This is testing method for PriceComaparator and sorted cars into lowest Price
	 * 	
	 */
	
	@Test
	public void testCompare_Price() {
		ArrayList<Car> usedCars = new ArrayList<Car>();
		usedCars.add(new Car(5000, 1999, 14));
		usedCars.add(new Car(8000, 2015, 12));
		usedCars.add(new Car(12000, 2017, 18));
		usedCars.add(new Car(1000, 2010, 16));
		Collections.sort(usedCars, new PriceComparator());
		ArrayList<Integer> actual = new ArrayList<>();
		for (Car a : usedCars) {
			actual.add(a.getPrice());
			
		}
		ArrayList<Integer> expected = new ArrayList<>();
		expected.add(5000);
		expected.add(8000);
		expected.add(12000);
		expected.add(1000);
		Collections.sort(expected);
		assertThat(actual, is(expected));
	}

}
