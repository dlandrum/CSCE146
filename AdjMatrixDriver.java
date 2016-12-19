//This class brought to you by Don Landrum
public class AdjMatrixDriver {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Creating adjacency matrix");
		AdjMatrix graph = new AdjMatrix(7);
		System.out.println("Adding edges");
		graph.addEdge(0, 1, 1);//edge from 1 to 2
		graph.addEdge(0, 3, 1);//edge from 1 to 4
		graph.addEdge(1, 3, 1);//edge from 2 to 4
		graph.addEdge(2, 0, 1);//edge from 3 to 1
		graph.addEdge(2, 4, 1);//edge from 3 to 5
		graph.addEdge(2, 5, 1);//edge from 3 to 6
		graph.addEdge(3, 2, 1);//edge from 4 to 3
		graph.addEdge(3, 4, 1);//edge from 4 to 5
		graph.addEdge(4, 5, 1);//edge from 5 to 6
		graph.addEdge(4, 6, 1);//edge from 5 to 7
		System.out.println("Printing DFS for all vertices");
		graph.printDFSForAll();
		System.out.println("Printing BFS for all vertices");
		graph.printBFSForAll();
	}
}