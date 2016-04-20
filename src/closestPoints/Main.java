package closestPoints;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	private Scanner inFile;
	private ClosestPoints cp;
	private String s = "";
	
	public Main(String[] fileName) {
		cp = new ClosestPoints();
		try {
			inFile = new Scanner(new File(fileName[0]));

			String line = inFile.nextLine();
	while(!line.startsWith("NODE")){
		line = inFile.nextLine();
	}
	line = inFile.nextLine();
	while(!line.startsWith("EOF") && inFile.hasNextLine()){
		String[] stringArray = line.split(" ");
		ArrayList<String> listWithoutEmptyStrings= new ArrayList<String>();
		for(int i = 0; i < stringArray.length; i++){
			if(!stringArray[i].isEmpty()){
				listWithoutEmptyStrings.add(stringArray[i]);
			}
		}
		String name = listWithoutEmptyStrings.get(0);
		Double x = Double.parseDouble(listWithoutEmptyStrings.get(1));
		Double y = Double.parseDouble(listWithoutEmptyStrings.get(2));
		cp.addPoint(name, x, y);
		line = inFile.nextLine();
		if(line.startsWith(" ")){
			line = line.substring(1);
		}
	}
	cp.divideAndConquer();
//	cp.printPoints();
//	System.out.println(cp.getShortestPoints());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new Main(args);
		//new Main("wc-instance-65534.txt");
	}

}
