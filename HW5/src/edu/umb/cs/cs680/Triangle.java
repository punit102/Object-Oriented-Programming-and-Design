package edu.umb.cs.cs680;
import java.awt.Point;
import java.util.ArrayList;

public class Triangle implements Polygon {

	private Point A, B, C;
	private ArrayList<Point> p = new ArrayList<Point>();
	Triangle(Point A, Point B, Point C) {
		this.A = A;
		this.B = B;
		this.C = C;
	}

	@Override
	public double getArea() {

		double x1 = A.x;
		double y1 = A.y;
		double x2 = B.x;
		double y2 = B.y;
		double x3 = C.x;
		double y3 = C.y;
		double a = Math.sqrt(Math.pow(Math.abs(x1 - x2), 2) + Math.pow(Math.abs(y1 - y2), 2));
		double b = Math.sqrt(Math.pow(Math.abs(x2 - x3), 2) + Math.pow(Math.abs(y2 - y3), 2));
		double c = Math.sqrt(Math.pow(Math.abs(x3 - x1), 2) + Math.pow(Math.abs(y3 - y1), 2));
		double s = (a + b + c) / 2;
		double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
		return area;
	}

	@Override
	public ArrayList<Point> getPoint() {
		
		p.add(A);
		p.add(B);
		p.add(C);
		return p;
	}

	@Override
	public Point getCentroid() {

		int x1 = A.x;
		int x2 = B.x;
		int x3 = C.x;
		int y1 = A.y;
		int y2 = B.y;
		int y3 = C.y;
		double xCentreTemp = (x1 + x2 + x3) / 3;
		double yCentreTemp = (y1 + y2 + y3) / 3;
		int xCentre = (int) xCentreTemp;
		int yCentre = (int) yCentreTemp;
		Point tricentroid = new Point(xCentre, yCentre);
		return tricentroid;
	}

}
