//This class brought to you by Don Landrum
import java.io.*;
import java.util.Scanner;
public class ShapeBSTDriver {
	static final String IN_FILE_NAME = "shapeFile.txt";
	static final String delim = "\t";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShapeBST tree = new ShapeBST();
		System.out.println("Welcome to the shape tree tester");
		analyze(IN_FILE_NAME, tree);//populates the tree with data from file
		System.out.println();
		System.out.println("Printing pre-order");
		tree.preprint();//prints the tree in pre-order
		System.out.println();
		System.out.println("Printing in-order");
		tree.inprint();//prints the tree in-order
		System.out.println();
		System.out.println("Printing post-order");
		tree.postprint();//prints the tree in post-order
		System.out.println();
		System.out.println("The max area is: "+tree.maxArea());//gets the area of the farthest leaf to the right
		System.out.println();
		System.out.print("Deleting ");
		tree.delete(14.0);//deletes the node with area 14.0
		System.out.println();
		System.out.println("Printing in-order");
		tree.inprint();//prints the tree in-order
		System.out.println();
		System.out.println("Deleting values higher than 30");
		tree.deleteAbove(30.0);//deletes all nodes with area above 30.0
		System.out.println("Printing in-order");
		tree.inprint();//prints the tree in-order
	}
	public static void analyze(String fileName, ShapeBST aTree){
		try{
			System.out.println("Reading from file");
			Scanner fileScanner = new Scanner(new File(fileName));//opens a file scanner
			while(fileScanner.hasNextLine()){
				String fileLine = fileScanner.nextLine();//selects a line
				String [] splitLines = fileLine.split(delim);//splits it along tabs
				if(splitLines[0].equalsIgnoreCase("rectangle") || splitLines[0].equalsIgnoreCase("circle") || splitLines[0].equalsIgnoreCase("right triangle")){
					if(splitLines.length == 3){//rectangle or triangle
						if(splitLines[0].contains("ectangle")){//creates and adds rectangle to tree then prints file line
							Rectangle b = new Rectangle(Double.parseDouble(splitLines[1]), Double.parseDouble(splitLines[2]));
							aTree.insert(b);
							System.out.println(fileLine);
						}
						else{//creates and adds triangle to tree then prints file line
							RightTriangle a = new RightTriangle(Double.parseDouble(splitLines[1]), Double.parseDouble(splitLines[2]));
							aTree.insert(a);
							System.out.println(fileLine);
						}
					}
					else{//creates and adds circle to tree then prints file line
						Circle c = new Circle(Double.parseDouble(splitLines[1]));
						aTree.insert(c);
						System.out.println(fileLine);
					}
				}	
				else{//error checking on file format
					System.out.println("Error, improper input");
				}
			}
			fileScanner.close();//closes file scanner
		}
		catch(FileNotFoundException e){//in case the file is not found
			e.getMessage();
		}
	}
}