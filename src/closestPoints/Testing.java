package closestPoints;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Testing {
	ClosestPoints cp;
	
	@Before
	public void setUp() throws Exception {
		cp = new ClosestPoints();
	}

	@Test
	public void test() {
		cp.addPoint("a", 10, 10);
		cp.addPoint("b", 5, 10);
		cp.addPoint("c", 2, 10);
//		cp.addPoint("d", 0, 0.1);
//		cp.addPoint("e", -121, 0);
//		cp.addPoint("f", 12, 0);
//		cp.addPoint("g", 17, 2);
//		cp.addPoint("h", 2.9, 0);
		//cp.printPoints();
		cp.divideAndConquer();
		System.out.println(cp.getShortestPoints());
		//cp.printPoints();
	}

}
