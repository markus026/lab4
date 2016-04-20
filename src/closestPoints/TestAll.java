package closestPoints;

import org.junit.After;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Test;

import java.io.*;


public class TestAll {
	private final static String TESTDATA_DIR = "/h/dk/z/dat14mge/edaf05/lab3files/data/";
	private final static char SC = File.separatorChar;
	
	/**
	 * Method to run an actual test case.
	 * 
	 * @param testname
	 *            Name of test data to be used, e.g. "stable-marriage-friends".
	 */
	private void runTestCase(String testname) {
		System.out.println("Running test: " + testname);
		String infile = TESTDATA_DIR + SC + testname + "-tsp.txt";
		
		String[] args = new String[1];
		args[0] = infile;
		Main.main(args);
	}

	/**
	 * Test case that will use all test data it can find in TESTDATA_DIR.
	 * 
	 * You may want to comment this out until you think your program works, as
	 * this test can take some time to execute.
	 */
	@Test
	public void testAll() {
		File dir = new File(TESTDATA_DIR);

		for (File f : dir.listFiles()) {
			if (f.isFile() && f.toString().endsWith("-tsp.txt")) {
				String s = f.toString();
				s = s.substring(s.lastIndexOf(SC) + 1);
				s = s.substring(0, s.lastIndexOf("-tsp.txt"));

				runTestCase(s);
			}
		}
	}



}