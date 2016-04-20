package closestPoints;

import java.util.Comparator;

public class Point implements Comparable {
	String name;
	 double x;
	private double y;
	
	public Point(String name, double x, double y){
		this.name = name;
		this.x = x;
		this.y = y;
	}

	
	public String info(){
		return name + ": " + x + " - " + y;
	}

	@Override
	public int compareTo(Object o) {	
		return Double.compare(x, ((Point) o).x);
	}
	
	public double distanceTo(Point other){
		double xDist = x - other.x;
		double yDist = y - other.y;
		return Math.sqrt((xDist * xDist) + (yDist * yDist));
	}
}
