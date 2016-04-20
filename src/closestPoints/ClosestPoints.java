package closestPoints;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClosestPoints {
	private ArrayList<Point> points;
	private String shortestPoints;
	private String shortestPoints2;
	private String shortest;

	public ClosestPoints() {
		points = new ArrayList<Point>();
	}

	public void addPoint(String name, double x, double y) {
		points.add(new Point(name, x, y));
	}

	public void divideAndConquer() {
		points.sort(null);

		double d = recursion(points);
		if (points.size() == 2) {
			shortest = shortestPoints2;
		}
		System.out.println(d);
	}

	private double recursion(List<Point> list) {
		if (list.size() == 2) {
			double distance = list.get(0).distanceTo(list.get(1));
			shortestPoints2 = list.get(0).name + " - " + list.get(1).name;
			return distance;
			
		} else if (list.size() == 1) {
			return Double.MAX_VALUE;
			
		} else {
			int halve = list.size() / 2;
			List<Point> firstHalve = list.subList(0, halve);
			List<Point> secondHalve = list.subList(halve, list.size());
			double distance1 = recursion(firstHalve);
			double distance2 = recursion(secondHalve);

			double distanceOnePointOnEachSide = Double.MAX_VALUE;
			double delta;
			
			if (distance1 <= distance2) {
				delta = distance1;
			} else {
				delta = distance2;
			}

			ArrayList<Point> tempFirst = new ArrayList<Point>();
			ArrayList<Point> tempSecond = new ArrayList<Point>();
			for (int i = 0; i < firstHalve.size(); i++) {
				double distanceToMiddle = Math.abs(firstHalve.get(i).x - secondHalve.get(0).x);
				if (distanceToMiddle < delta) {
					tempFirst.add(firstHalve.get(i));
				}
			}
			for (int i = 0; i < secondHalve.size(); i++) {
				double distanceToMiddle = Math.abs(secondHalve.get(i).x - secondHalve.get(0).x);
				if (distanceToMiddle < delta) {
					tempSecond.add(secondHalve.get(i));
				}
			}
			for (int i = 0; i < tempFirst.size(); i++) {
				for (int j = 0; j < tempSecond.size(); j++) {
					double temp = tempFirst.get(i).distanceTo(tempSecond.get(j));
					if (temp < distanceOnePointOnEachSide) {
						shortestPoints = tempFirst.get(i).name + " - " + tempSecond.get(j).name;
						distanceOnePointOnEachSide = temp;
					}
				}
			}

			if (distance1 <= distance2) {
				if (distance1 <= distanceOnePointOnEachSide) {
					shortest = shortestPoints2;
					return distance1;
				}
			}
			if (distance2 <= distance1) {
				if (distance2 <= distanceOnePointOnEachSide) {
					shortest = shortestPoints2;
					return distance2;
				}
			}
			shortest = shortestPoints;
			return distanceOnePointOnEachSide;
		}
	}

	public String getShortestPoints() {
		return shortest;
	}

	public void printPoints() {
		for (Point p : points) {
			System.out.println(p.info());
		}
	}
}
