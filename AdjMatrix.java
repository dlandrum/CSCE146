//This class brought to you by Don Landrum
import java.util.*;
public class AdjMatrix {
	private static final int DEFAULT_NODE_COUNT = 10;
	private double [][] adjMatrix;
	private ArrayList <Integer> markedVert;
	private ArrayList <Integer> visitVert;
	public AdjMatrix(){//I don't initialize these because it's java, so these are all 0.0
		adjMatrix = new double[DEFAULT_NODE_COUNT][DEFAULT_NODE_COUNT];//makes a ten by ten graph
		markedVert = new <Integer>ArrayList();
		visitVert = new <Integer>ArrayList();
	}
	public AdjMatrix(int aSize){
		if(aSize<= 0)
			return;
		adjMatrix = new double[aSize][aSize];//makes a square graph of the size inputted
		markedVert = new <Integer>ArrayList();
		visitVert = new <Integer>ArrayList();
	}
	public void addEdge(int startV, int endV, double weight){
		if(startV < 0 || endV < 0)//impossible vertices
			return;
		adjMatrix[startV][endV] = weight;//places the edge in the matrix
	}
	public void printDFS(){
		markedVert.clear();
		printDFS(0);//helper method
	}
	public void printDFS(int index){//I made this public to make it able to be accessed from any point
		System.out.println(index+1);//visit the index, accounting for the inaccurate naming of vertices
		markedVert.add(index);
		for(int i = 0; i<adjMatrix.length;i++){
			if(adjMatrix[index][i] != 0.0 && markedVert.contains(i)==false){//found a neighbor, not yet visited
				printDFS(i);//recursive call on the neighbor
			}
		}
	}
	public void printBFS(){
		markedVert.clear();
		visitVert.clear();
		printBFS(0);//helper method
	}
	public void printBFS(int index){//I made this public to make it able to be accessed from any point
		Queue<Integer> aQueue = new LinkedList<Integer>();//uses a queue to force the BFS to run in order, because a simple arraylist allows it to run out of order
		aQueue = printBFSHelp(index, aQueue);
		while(aQueue != null){
			aQueue = printBFSHelp(aQueue.remove(), aQueue);//recursive call, moves to the neighbor
		}
		
	}
	private Queue printBFSHelp(int index, Queue aQueue){
		if(visitVert.contains(index)==false){
			System.out.println(index+1);//visit the index, accounting for the inaccurate naming of vertices
			visitVert.add(index);
		}
		markedVert.add(index);
		for(int i = 0; i<adjMatrix.length; i++){
			if(adjMatrix[index][i]!=0 && visitVert.contains(i)==false){
				System.out.println(i+1);//visits the neighbor, accounting for the inaccurate naming of vertices
				visitVert.add(i);
			}
		}
		for(int i = 0; i<adjMatrix.length; i++){
			if(adjMatrix[index][i]!=0 && markedVert.contains(i)==false){
				aQueue.add(i);
			}
		}
		if(aQueue.size()>0){
			return aQueue;
		}
		else{
			return null;
		}
	}
	public void printDFSForAll(){//prints the DFS with each index as the starting point
		for(int i = 0; i<adjMatrix.length; i++){
			System.out.println("DFS for vertex "+(i+1)+": ");//accounts for inaccurate naming of vertices
			markedVert.clear();
			printDFS(i);
			System.out.println();
		}
	}
	public void printBFSForAll(){//prints the BFS with each index as the starting point
		for(int i = 0; i<adjMatrix.length; i++){
			System.out.println("BFS for vertex "+(i+1)+": ");//accounts for inaccurate naming of vertices
			markedVert.clear();
			visitVert.clear();
			printBFS(i);
			System.out.println();
		}
	}
}