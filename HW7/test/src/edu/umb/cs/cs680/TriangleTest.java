package edu.umb.cs.cs680;

import static org.junit.Assert.*;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import java.awt.Point;
import java.util.ArrayList;

public class TriangleTest {

	// This is first Triangle getArea testing Method
	@Test
	public void testGetArea() {

		Triangle t = new Triangle(new Point(0, 0), new Point(0, 6), new Point(6, 0));
		double expected = 17.99999999999999;
		double actual = t.getArea();
		assertThat(actual, is(expected));

	}

	// This is first Triangle getPoint testing Method
	@Test
	public void testGetPoint() {

		Triangle t = new Triangle(new Point(0, 0), new Point(0, 6), new Point(6, 0));
		ArrayList<Point> p = new ArrayList<Point>();
		p.add(new Point(0, 0));
		p.add(new Point(0, 6));
		p.add(new Point(6, 0));
		ArrayList<Point> expected = p;
		ArrayList<Point> actual = t.getPoint();
		assertThat(actual, is(expected));
	}

	// This is first Triangle getCentroid testing Method
	@Test
	public void testGetCentroid() {
		Triangle t = new Triangle(new Point(0, 0), new Point(0, 6), new Point(6, 0));
		Point expected = new Point(2, 2);
		Point actual = t.getCentroid();
		assertThat(actual, is(expected));
	}
	
	
	
	// This is second Triangle getArea testing Method
	@Test
	public void testGetArea2() {

		Triangle t = new Triangle(new Point(0, 0), new Point(0, 10), new Point(10, 0));
		double expected = 50.0;
		double actual = t.getArea();
		assertThat(actual, is(expected));

	}

	// This is second Triangle getPoint testing Method
	@Test
	public void testGetPoint2() {

		Triangle t = new Triangle(new Point(0, 0), new Point(0, 10), new Point(10, 0));
		ArrayList<Point> p = new ArrayList<Point>();
		p.add(new Point(0, 0));
		p.add(new Point(0, 10));
		p.add(new Point(10, 0));
		ArrayList<Point> expected = p;
		ArrayList<Point> actual = t.getPoint();
		assertThat(actual, is(expected));
	}

	
	// This is second Triangle getCentroid testing Method
	@Test
	public void testGetCentroid2() {
		Triangle t = new Triangle(new Point(0, 0), new Point(0, 10), new Point(10, 0));
		Point expected = new Point(3, 3);
		Point actual = t.getCentroid();
		assertThat(actual, is(expected));
	}
	
	
	

}
