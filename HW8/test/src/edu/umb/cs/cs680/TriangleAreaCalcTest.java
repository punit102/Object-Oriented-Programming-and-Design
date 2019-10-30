package edu.umb.cs.cs680;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.awt.Point;
import java.util.ArrayList;

import org.junit.Test;

public class TriangleAreaCalcTest {

	
	/*
	 * 
	 * This is normal Triangle area calculation testing method
	 * 
	 * 
	 */
	
	@Test
	public void testGetArea() {

		ArrayList<Point> al = new ArrayList<Point>();
		al.add(new Point(0, 0));
		al.add(new Point(4, 0));
		al.add(new Point(0, 6));
		Polygon p = new Polygon(al, new TriangleAreaCalc());
		float expected = 12.0f;
		float actual = p.getArea();
		assertThat(actual, is(expected));

	}

	
	/*
	 * 
	 * This is normal Triangle getCentroid calculation testing method
	 * 
	 * 
	 * */
	
	@Test
	public void testGetCentroid() {

		ArrayList<Point> al = new ArrayList<Point>();
		al.add(new Point(0, 0));
		al.add(new Point(4, 0));
		al.add(new Point(0, 6));
		Polygon p = new Polygon(al, new TriangleAreaCalc());
		Point expected = new Point(1, 2);
		Point actual = p.getCentroid();
		assertThat(actual, is(expected));
	}

	
	/*
	 * 
	 * This is dynamically changing triangle -> Rectangle getArea testing calculation method 
	 * 
	 * 
	 * */
	
	@Test
	public void testGetArea_dynamically() {

		ArrayList<Point> al = new ArrayList<Point>();
		al.add(new Point(0, 0));
		al.add(new Point(4, 0));
		al.add(new Point(0, 6));
		Polygon p = new Polygon(al, new TriangleAreaCalc());
		p.addPoint(new Point(4, 6));
		p.setAreaCalc(new RectangleAreaCalc());
		float expected = 24.0f;
		float actual = p.getArea();
		assertThat(actual, is(expected));

	}

	
	/*
	 * 
	 * This is dynamically changing triangle -> Rectangle getCentroid testing calculation method 
	 * 
	 * 
	 * */
	
	@Test
	public void testGetCentroid_dynamically() {

		ArrayList<Point> al = new ArrayList<Point>();
		al.add(new Point(0, 0));
		al.add(new Point(4, 0));
		al.add(new Point(0, 6));
		Polygon p = new Polygon(al, new TriangleAreaCalc());
		p.addPoint(new Point(4, 6));
		p.setAreaCalc(new RectangleAreaCalc());
		Point expected = new Point(2, 3);
		Point actual = p.getCentroid();
		assertThat(actual, is(expected));
	}

}
