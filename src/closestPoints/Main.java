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
//		while(line.startsWith(" ")){
//			line = line.substring(1);
//		}
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
	//	System.out.println(name + ": " + x + " --- " + y);
		line = inFile.nextLine();
	}
	cp.divideAndConquer();
	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new Main(args);
		//new Main("pr1002-tsp.txt");
		//new Main("a280-tsp.txt");
		//new Main("ali535-tsp.txt");
		//new Main("att48-tsp.txt");
		//new Main("att532-tsp.txt");
		//new Main("berlin52-tsp.txt");
		//new Main("bier127-tsp.txt");
		//new Main("brd14051-tsp.txt");
		//new Main("burma14-tsp.txt");
		//new Main("ch130-tsp.txt");
		//new Main("ch150-tsp.txt");
		//new Main("d1291-tsp.txt");
		//new Main("d15112-tsp.txt");
		//new Main("d1655-tsp.txt");
		//new Main("d18512-tsp.txt");
		//new Main("d198-tsp.txt");
		//new Main("d2103-tsp.txt");
		//new Main("d493-tsp.txt");
		//new Main("d657-tsp.txt");
		//new Main("dsj1000-tsp.txt");
		//new Main("eil101-tsp.txt");
		//new Main("eil51-tsp.txt");
		//new Main("eil76-tsp.txt");
		//new Main("fl1400-tsp.txt");
		//new Main("fl1577-tsp.txt");
		//new Main("fl3795-tsp.txt");
		//new Main("fl417-tsp.txt");
		//new Main("fnl4461-tsp.txt");
		//new Main("gil262-tsp.txt");
		//new Main("gr137-tsp.txt");
		//new Main("gr202-tsp.txt");
		//new Main("gr229-tsp.txt");
		//new Main("gr431-tsp.txt");
		//new Main("gr666-tsp.txt");
		//new Main("gr96-tsp.txt");
		//new Main("kroA100-tsp.txt");
		//new Main("kroA150-tsp.txt");

	}

}
