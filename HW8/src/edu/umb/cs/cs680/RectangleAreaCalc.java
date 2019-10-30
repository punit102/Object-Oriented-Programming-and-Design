package edu.umb.cs.cs680;

import java.awt.Point;
import java.util.ArrayList;

public class RectangleAreaCalc implements AreaCalculator {


	@Override
	public float getArea(ArrayList<Point> points) {
		double x1 = points.get(0).getX();
		double y1 = points.get(0).getY();
		double x2 = points.get(1).getX();
		double y2 = points.get(1).getY();
		double x3 = points.get(2).getX();
		double y3 = points.get(2).getY();
		//double x4 = points.get(3).getX();
		//double y4 = points.get(3).getY();
		double a = Math.sqrt(Math.pow(Math.abs(x1 - x2), 2) + Math.pow(Math.abs(y1 - y2), 2));
		double b = Math.sqrt(Math.pow(Math.abs(x1 - x3), 2) + Math.pow(Math.abs(y1 - y3), 2));
		double area = a * b;
		return (float) area;	
	}

	@Override
	public Point getCentroid(ArrayList<Point> points) {
		
		double x1 = points.get(0).getX();
		double y1 = points.get(0).getY();
		double x2 = points.get(1).getX();
		double y2 = points.get(1).getY();
		double x3 = points.get(2).getX();
		double y3 = points.get(2).getY();
		double xSideMap = Math
				.sqrt(Math.pow(Math.abs(x1 - x2), 2) + Math.pow(Math.abs(y1 - y2), 2));
		double ySideMap = Math
				.sqrt(Math.pow(Math.abs(x1 - x3), 2) + Math.pow(Math.abs(y1 - y3), 2));
		double xCentroidTemp = xSideMap / 2;
		double yCentroidTemp = ySideMap / 2;
		int xCentroid = (int) xCentroidTemp;
		int yCentroid = (int) yCentroidTemp;
		Point reccentroid = new Point(xCentroid, yCentroid);
		return reccentroid;
	}

}
