package edu.umb.cs.cs680;

import java.awt.Point;
import java.util.ArrayList;

public class TriangleAreaCalc implements AreaCalculator {

	@Override
	public float getArea(ArrayList<Point> points) {

		double x1 = points.get(0).getX();
		double y1 = points.get(0).getY();
		double x2 = points.get(1).getX();
		double y2 = points.get(1).getY();
		double x3 = points.get(2).getX();
		double y3 = points.get(2).getY();
		double a = Math.sqrt(Math.pow(Math.abs(x1 - x2), 2) + Math.pow(Math.abs(y1 - y2), 2));
		double b = Math.sqrt(Math.pow(Math.abs(x2 - x3), 2) + Math.pow(Math.abs(y2 - y3), 2));
		double c = Math.sqrt(Math.pow(Math.abs(x3 - x1), 2) + Math.pow(Math.abs(y3 - y1), 2));
		double s = (a + b + c) / 2;
		double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
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
		double xCentreTemp = (x1 + x2 + x3) / 3;
		double yCentreTemp = (y1 + y2 + y3) / 3;
		int xCentre = (int) xCentreTemp;
		int yCentre = (int) yCentreTemp;
		Point tricentroid = new Point(xCentre, yCentre);
		return tricentroid;
	}

}
