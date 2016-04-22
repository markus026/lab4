package closestPoints;

import java.util.Comparator;

public class YComparator implements Comparator<Point> {
	
	public YComparator(){
		
	}

	@Override
	public int compare(Point o1, Point o2) {
		
		return Double.compare(o1.y, o2.y);
	}
}
