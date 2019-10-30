package edu.umb.cs.cs680;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Collections;
import org.junit.Test;

public class MileageComparatorTest {

	/*
	 * 
	 * 
	 * This is testing method for MileageComaparator and sorted cars into lowest Mileage
	 * 	
	 */

	@Test
	public void testCompare_Mileage() {

		ArrayList<Car> usedCars = new ArrayList<Car>();
		usedCars.add(new Car(5000, 1999, 14));
		usedCars.add(new Car(8000, 2015, 12));
		usedCars.add(new Car(12000, 2017, 18));
		usedCars.add(new Car(1000, 2010, 16));
		Collections.sort(usedCars, new MileageComparator());
		ArrayList<Integer> actual = new ArrayList<>();
		for (Car a : usedCars) {
			actual.add(a.getMileage());

		}
		ArrayList<Integer> expected = new ArrayList<>();
		expected.add(12);
		expected.add(18);
		expected.add(14);
		expected.add(16);
		Collections.sort(expected);
		assertThat(actual, is(expected));

	}

}
