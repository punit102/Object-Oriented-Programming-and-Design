package edu.umb.cs.cs680;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

public class YearComparatorTest {

	
	/*
	 * 
	 * 
	 * This is testing method for YearComaparator and sorted cars into most recent year
	 * 	
	 */
	
	@Test
	public void testCompare_Year() {
		ArrayList<Car> usedCars = new ArrayList<Car>();
		usedCars.add(new Car(5000, 1999, 14));
		usedCars.add(new Car(8000, 2015, 12));
		usedCars.add(new Car(12000, 2017, 18));
		usedCars.add(new Car(1000, 2010, 16));
		Collections.sort(usedCars, new YearComparator());
		ArrayList<Integer> actual = new ArrayList<>();
		for (Car a : usedCars) {
			actual.add(a.getYear());
			
		}
		ArrayList<Integer> expected = new ArrayList<>();
		expected.add(1999);
		expected.add(2015);
		expected.add(2017);
		expected.add(2010);
		Collections.sort(expected);
		Collections.reverse(expected);
		assertThat(actual, is(expected));
		
	}

}
