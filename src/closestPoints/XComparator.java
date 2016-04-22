package closestPoints;

import java.util.Comparator;

public class XComparator implements Comparator<Point> {
	
	public XComparator(){
		
	}

	@Override
	public int compare(Point o1, Point o2) {
		
		return Double.compare(o1.x, o2.x);
	}
}
