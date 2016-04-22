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
//		cp.addPoint("a", 11, 0.05);
//		cp.addPoint("b", 5, 10);
//		cp.addPoint("c", 2, 10);
//		cp.addPoint("d", 0, 10.1);
//		cp.addPoint("e", -121, 0);
//		cp.addPoint("f", 12, -0);
//		cp.addPoint("g", 17, 2);
//		cp.addPoint("h", 2.9, -30);
//		cp.printPoints();
		
		cp.addPoint("1", 16.47, 96.10);
		cp.addPoint("2", 16.47, 94.44);
		cp.addPoint("3", 20.09, 92.54);
		cp.addPoint("4", 22.39, 93.37);
		cp.addPoint("5", 25.23, 97.24);
		cp.addPoint("6", 22.00, 96.05);
		cp.addPoint("7", 20.47, 97.02);
		cp.addPoint("8", 17.20, 96.29);
		//cp.addPoint("9", 16.30, 97.38);
		//cp.addPoint("10", 14.05, 98.12);
		
		
		cp.divideAndConquer();
	//	System.out.println();
		System.out.println(cp.getClosestPoints());
//		cp.printPoints();
	//	cp.printPoints();
	}

}
