package closestPoints;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClosestPoints {
	private ArrayList<Point> points;

	public ClosestPoints(){
		points = new ArrayList<Point>();
	}
	
	public void addPoint(String name, double x, double y){
		points.add(new Point(name, x, y));
	}
	
	public void divideAndConquer(){
		//Collections.sort(points);
		points.sort(null);
		//printPoints(points);
		
		double d = recursion(points);
		System.out.println(d);
		//printPoints(firstHalve);
		//System.out.println();
		//printPoints(secondHalve);
	}
	
	private double recursion(List<Point> list){
		if(list.size() == 2){
			double distance = list.get(0).distanceTo(list.get(1));
			return distance;
		}
		else if(list.size() == 1){
			return Double.MAX_VALUE;
		}
		else{
		int halve = list.size() / 2;
		List<Point> firstHalve =  list.subList(0, halve);
		List<Point> secondHalve = list.subList(halve, list.size());
		double distance1 = recursion(firstHalve);
		double distance2 = recursion(secondHalve);
		
		double distanceOnePointOnEachSide = Double.MAX_VALUE;
//		double delta;
//		if(distance1 <= distance2){
//			delta = distance1;
//		}
//		else{
//			delta = distance2;
//		}
//		for(Point p:list){
//			if(Math.abs(p.x - secondHalve.get(0).x))
//		}
		for(int i = 0; i < firstHalve.size(); i++){
			for (int j = 0; j < secondHalve.size(); j++){
				double temp = firstHalve.get(i).distanceTo(secondHalve.get(j));
				if(temp < distanceOnePointOnEachSide){
					distanceOnePointOnEachSide = temp; 
				}
			}
		}
		if(distance1 <= distance2){
			if(distance1 <= distanceOnePointOnEachSide){
				return distance1;
			}
		}
		if(distance2 <= distance1){
			if(distance2 <= distanceOnePointOnEachSide){
				return distance2;
			}
		}
		return distanceOnePointOnEachSide;
		}
	}
	
	public void printPoints(List<Point> list){
		for(Point p:list){
			System.out.println(p.info());
		}
	}
}
