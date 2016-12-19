//This class provided by Dr. JJ and filled out by Don Landrum
import java.util.*;
public class Graph {
	private class Vertex//given
	{
		String name;
		ArrayList<Edge> neighbors;//lists of edges that connect the verticies
		public Vertex(String aName)
		{
			this.name = aName;
			this.neighbors = new ArrayList<Edge>();//an array list of edges
		}
	}
	private class Edge//given
	{
		Vertex nextVert;
		double weight;
		public Edge(Vertex aV1, double aWeight)
		{
			nextVert = aV1;
			weight = aWeight;
		}
	}
	private Vertex origin;
	private ArrayList<Vertex> verticies;
	private ArrayList<Vertex> markedVerts;
	private ArrayList<Vertex> visitedVerts;
	private double maxLength; 
	public Graph(double aLength)//given
	{
		origin = null;//for this example, the origin is the first vertex added, but it's arbitrary
		verticies = new ArrayList<Vertex>();
		markedVerts = new ArrayList<Vertex>();
		visitedVerts = new ArrayList<Vertex>();
		maxLength = aLength;
	}
	//everything after this was written, not given
	public void addVertex(String aString){//adds a Vertex given a name
		if(vertexIsContained(aString))//error checking, does not allow two verticies of same name
			return;
		Vertex aVertex = new Vertex(aString);
		verticies.add(aVertex);
		if(origin == null)//sets the first vertex entered to the origin
			origin = aVertex;
	}
	public boolean vertexIsContained(String aString){//determines whether the vertex is in the graph
		for(Vertex vert : verticies){
			if(vert.name.equals(aString))
				return true;
		}
		return false;
	}
	public void addEdge(String aString, String bString, double aWeight){//aString is the start point, bString is the end point
		Vertex aVertex = getVertex(aString);
		Vertex bVertex = getVertex(bString);
		if(aVertex == null || bVertex == null)//error checking, ends the method if the vertices are not found
			return;
		Edge anEdge = new Edge(bVertex, aWeight);//creates edge
		aVertex.neighbors.add(anEdge);//adds edge to neighbors of the first vertex
	}
	public Vertex getVertex(String aString){//searches through, returns the vertex with the specified name
		for(Vertex vert : verticies){
			if(vert.name.equals(aString))
				return vert;
		}
		return null;
	}
	public void printBFS(){
		markedVerts.clear();//clear the ArrayLists
		visitedVerts.clear();
		System.out.println(origin.name);//"visit" the origin
		printBFS(origin);//helper method
	}
	private void printBFS(Vertex aVert){//helper method
		if(markedVerts.contains(aVert))
			return;//go back up
		markedVerts.add(aVert);
		for(Edge e : aVert.neighbors){//visits everything in this level
			if(visitedVerts.contains(e.nextVert) || markedVerts.contains(e.nextVert)){//if the neighbor has been visited or marked
				continue;
				//Do nothing
			}
			else{
				System.out.println(e.nextVert.name);//prints the name, visits it
				visitedVerts.add(e.nextVert);//adds it to visitedVerts
			}
		}
		for(Edge e : aVert.neighbors){//goes down to next level
			printBFS(e.nextVert);//recursive call
		}
	}
	public void printDFS(){
		markedVerts.clear();//clears the list of marked verticies
		printDFS(origin);//starts at the so-called head
	}
	private void printDFS(Vertex aVert){//helper method
		if(markedVerts.contains(aVert))
			return;//if the vertex I'm looking at has already been looked at
		System.out.println(aVert.name);//visits vertex
		markedVerts.add(aVert);
		for(Edge e : aVert.neighbors){//for each of the vertex's neighbors
			printDFS(e.nextVert);//recursive call
		}
	}
	public void printLazyDFS(){
		markedVerts.clear();//clears the list of marked verticies
		printLazyDFS(origin);//starts at the so-called head
	}
	private void printLazyDFS(Vertex aVert){//helper method
		if(markedVerts.contains(aVert))
			return;//if the vertex I'm looking at has already been looked at
		System.out.println(aVert.name);//visits vertex
		markedVerts.add(aVert);
		for(Edge e : aVert.neighbors){//for each of the vertex's neighbors
			if(e.weight<maxLength)//makes the method lazy
				printLazyDFS(e.nextVert);//recursive call
		}
	}
}





/*
Graph Notes:
Linked structure vs Adjacency matrix, it really depends on the problem 
in a binary tree, basically always use a linked list
in a heap, basically always use an array
Depth first search: Pay very close attention to which node we start from in this search
DEPTH FIRST SEARCH WILL BE ON THE EXAM
To break ties between children, we visit the smaller child of the vertex first
It's not always a bug, it's a feature
DFS has a lot of theoretical inconsistencies
DFS actually is not verifiable; that is, it cannot be proven to print every vertex!! It's very inefficient in worst case and as it approaches infinity, it breaks completely
BFS is verifiable, but it's harder to code
BFS is wide, not deep
visit all children of a node, then mark it, then mark one of its kids, so on
*/