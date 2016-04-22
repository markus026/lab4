package closestPoints;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClosestPoints {
	private ArrayList<Point> xList;
	private ArrayList<Point> yList;
	private Pair closestPair;
	private XComparator xc = new XComparator();
	private YComparator yc = new YComparator();

	public ClosestPoints() {
		xList = new ArrayList<Point>();
		yList = new ArrayList<Point>();
	}

	public void addPoint(String name, double x, double y) {
		xList.add(new Point(name, x, y));
		yList.add(new Point(name, x, y));
	}

	public void divideAndConquer() {
		xList.sort(xc);
		yList.sort(yc);
		closestPair = closestPairRec(xList, yList);
		System.out.println(closestPair.distance);
	}

	private Pair closestPairRec(List<Point> xList, List<Point> yList) {
		if (xList.size() <= 3) {
			Pair p1p2 = new Pair(new Point("a", Double.MAX_VALUE, Double.MAX_VALUE),
					new Point("b", Double.MAX_VALUE, Double.MAX_VALUE), Double.MAX_VALUE);
			double distance = Double.MAX_VALUE;
			if (xList.size() > 1) {
				distance = xList.get(0).distanceTo(xList.get(1));
				p1p2 = new Pair(xList.get(0), xList.get(1), distance);
			}
			if (xList.size() > 2) {
				double distance2 = xList.get(1).distanceTo(xList.get(2));
				double distance3 = xList.get(0).distanceTo(xList.get(2));
				if (distance2 < distance && distance2 < distance3) {
					distance = distance2;
					p1p2 = new Pair(xList.get(1), xList.get(2), distance);
				} else if (distance3 < distance) {
					distance = distance3;
					p1p2 = new Pair(xList.get(0), xList.get(2), distance);
				}
			}
			return p1p2;
		}

		else {
			int halve = xList.size() / 2;
			List<Point> leftX = xList.subList(0, halve);
			List<Point> rightX = xList.subList(halve, xList.size());
			List<Point> leftY = new ArrayList<Point>();
			List<Point> rightY = new ArrayList<Point>();
			for (Point p : yList) {
				if (p.x < xList.get(halve).x) {
					leftY.add(p);
				} else {
					rightY.add(p);
				}
			}

			Pair leftHalve = closestPairRec(leftX, leftY);
			Pair rightHalve = closestPairRec(rightX, rightY);

			double delta = Math.min(leftHalve.distance, rightHalve.distance);
			double xMax = leftX.get(leftX.size() - 1).x;
			ArrayList<Point> tempY = new ArrayList<Point>();
			for (int i = 0; i < yList.size(); i++) {
				double distanceToMiddle = Math.abs(yList.get(i).x - xMax);
				if (distanceToMiddle < delta) {
					tempY.add(yList.get(i));
				}
			}

			double tempDistance;
			double distancePointsWithinStrip = Double.MAX_VALUE;
			Pair pairDifferentSides = null;
			for (int i = 0; i < tempY.size(); i++) {
				for (int j = 1; j < 16; j++) {
					if (i + j < tempY.size()) {
						tempDistance = tempY.get(i).distanceTo(tempY.get(i + j));
						if (tempDistance < distancePointsWithinStrip) {
							distancePointsWithinStrip = tempDistance;
							pairDifferentSides = new Pair(tempY.get(i), tempY.get(i + j), distancePointsWithinStrip);
						}
					} else {
						break;
					}
				}
			}

			if (distancePointsWithinStrip < delta) {
				return pairDifferentSides;
			} else if (leftHalve.distance < rightHalve.distance) {
				return leftHalve;
			} else {
				return rightHalve;
			}
		}
	}

	public String getClosestPoints() {
		return "p1: " + closestPair.p1.info() + "\n" + "p2: " + closestPair.p2.info();
	}
}
