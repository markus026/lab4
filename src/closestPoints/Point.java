package closestPoints;

import java.util.Comparator;

public class Point implements Comparable {
	 double x;
	private double y;
	
	public Point(double x, double y){
		this.x = x;
		this.y = y;
	}

	
	public String info(){
		return x + " - " + y;
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
