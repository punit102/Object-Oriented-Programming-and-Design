package edu.umb.cs.cs680;

import java.awt.Point;
import java.util.ArrayList;

public class Polygon {
	private ArrayList<Point> points;
	private AreaCalculator areaCalc;
	
	Polygon(ArrayList<Point> points,AreaCalculator areaCalc){
		this.points = points;
		this.areaCalc = areaCalc;	
	}
	
	public AreaCalculator setAreaCalc(AreaCalculator areaCalc)
	{
		return this.areaCalc = areaCalc;
	}
	
	public Point addPoint(Point point)
	{
			points.add(point);
			return point;
	}
	
	public float getArea()
	{
		return areaCalc.getArea(points);
	}
	
	public Point getCentroid()
	{
		return areaCalc.getCentroid(points);
	}
	
	
	
}
