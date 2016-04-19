package closestPoints;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	private Scanner inFile;
	private ClosestPoints cp;
	private String s = "";

	public Main(String fileName) {
		cp = new ClosestPoints();
		try {
			inFile = new Scanner(new File(fileName));

			String line = inFile.nextLine();
	
	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

//	public static void main(String[] args) {
//		new Main("USA-highway-miles.txt");
//	//	new Main("tinyEWG-alpha.txt");
//
//	}

}
