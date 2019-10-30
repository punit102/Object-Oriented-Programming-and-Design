package edu.umb.cs.cs680;
import java.awt.Point;
import java.util.ArrayList;

public class Rectangle implements Polygon {

	private Point A, B, C, D;
	private ArrayList<Point> p = new ArrayList<Point>();

	Rectangle(Point A, Point B, Point C, Point D) {
		this.A = A;
		this.B = B;
		this.C = C;
		this.D = D;
	}

	public double getArea() {

		double x1 = A.getX();
		double y1 = A.getY();
		double x2 = B.getX();
		double y2 = B.getY();
		double x3 = C.getX();
		double y3 = C.getY();
		//double x4 = D.getX();
		//double y4 = D.getY();
		double a = Math.sqrt(Math.pow(Math.abs(x1 - x2), 2) + Math.pow(Math.abs(y1 - y2), 2));
		double b = Math.sqrt(Math.pow(Math.abs(x1 - x3), 2) + Math.pow(Math.abs(y1 - y3), 2));
		double area = a * b;
		return area;

	}
	
	@Override
	public ArrayList<Point> getPoint() {

		p.add(A);
		p.add(B);
		p.add(C);
		p.add(D);
		return p;
	}

	@Override
	public Point getCentroid() {

		double xSideMap = Math
				.sqrt(Math.pow(Math.abs(A.getX() - B.getX()), 2) + Math.pow(Math.abs(A.getY() - B.getY()), 2));
		double ySideMap = Math
				.sqrt(Math.pow(Math.abs(A.getX() - C.getX()), 2) + Math.pow(Math.abs(A.getY() - C.getY()), 2));
		double xCentroidTemp = xSideMap / 2;
		double yCentroidTemp = ySideMap / 2;
		int xCentroid = (int) xCentroidTemp;
		int yCentroid = (int) yCentroidTemp;
		Point reccentroid = new Point(xCentroid, yCentroid);
		return reccentroid;
	}
}
