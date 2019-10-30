package edu.umb.cs.cs680;
import java.awt.Point;
import java.util.ArrayList;

public interface Polygon {

	public double getArea();

	public ArrayList<Point> getPoint();

	public Point getCentroid();

}
