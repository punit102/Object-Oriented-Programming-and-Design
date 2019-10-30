package edu.umb.cs.cs680;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.awt.Point;
import java.util.ArrayList;

import org.junit.Test;

public class RectangleTest {

	// This is first Rectangle getArea testing Method
	@Test
	public void testGetArea() {
		Rectangle r = new Rectangle(new Point(0, 0), new Point(4, 0), new Point(6, 0), new Point(4, 6));
		double expected = 24.0;
		double actual = r.getArea();
		assertThat(actual, is(expected));
	}

	// This is first getPoint testing method of Rectangle
	@Test
	public void testGetPoint() {
		Rectangle r = new Rectangle(new Point(0, 0), new Point(4, 0), new Point(6, 0), new Point(4, 6));
		ArrayList<Point> p = new ArrayList<Point>();
		p.add(new Point(0, 0));
		p.add(new Point(4, 0));
		p.add(new Point(6, 0));
		p.add(new Point(4, 6));
		ArrayList<Point> expected = p;
		ArrayList<Point> actual = r.getPoint();
		assertThat(actual, is(expected));
	}

	// This is first getCentroid testing method of Rectangle
	@Test
	public void testGetCentroid() {
		Rectangle r = new Rectangle(new Point(0, 0), new Point(4, 0), new Point(6, 0), new Point(4, 6));
		Point expected = new Point(2, 3);
		Point actual = r.getCentroid();
		assertThat(actual, is(expected));
	}

	// This is second Rectangle area testing
	@Test
	public void testGetArea2() {
		Rectangle r = new Rectangle(new Point(0, 0), new Point(7, 0), new Point(0, 3), new Point(7, 3));
		double expected = 21.0;
		double actual = r.getArea();
		assertThat(actual, is(expected));

	}

	// This is second getPoint testing method of Rectangle
	@Test
	public void testGetPoint2() {
		Rectangle r = new Rectangle(new Point(0, 0), new Point(7, 0), new Point(0, 3), new Point(7, 3));
		ArrayList<Point> p = new ArrayList<Point>();
		p.add(new Point(0, 0));
		p.add(new Point(7, 0));
		p.add(new Point(0, 3));
		p.add(new Point(7, 3));
		ArrayList<Point> expected = p;
		ArrayList<Point> actual = r.getPoint();
		assertThat(actual, is(expected));
	}

	// This is second getCentroid testing method of Rectangle
	@Test
	public void testGetCentroid2() {
		Rectangle r = new Rectangle(new Point(0, 0), new Point(7, 0), new Point(0, 3), new Point(7, 3));
		Point expected = new Point(3, 1);
		Point actual = r.getCentroid();
		assertThat(actual, is(expected));
	}

}
