//This class brought to you by Don Landrum
public class IntBSTree {
	private static final int SIZE = 128;
	private int[] tree;
	public IntBSTree(){//default constructor, also populates with -1
		tree = new int [SIZE];
		for(int i = 0; i<SIZE; i++){
			tree[i] = -1;
		}
	}
	public IntBSTree(int aSize){//parameterized constructor, also populates with -1
		if(aSize>0){
			tree = new int [aSize];
			for(int i = 0; i<aSize; i++){
				tree[i] = -1;
			}
		}
		else{
			System.out.println("Impossible!");
			System.exit(0);
		}
	}
	public void insert(int a){
		if(a>=0){//error checking
			if(tree[0] == -1){//if the tree is empty
				tree[0] = a;
			}
			else{//helper method below
				insert(a, 0);
			}
		}
		else{//error checking
			System.out.println("Error. No negatives.");
		}
	}
	private void insert(int a, int i){
		if(tree[i] == -1){//"empty" index, inserts value
			tree[i] = a;
		}
		else if(a<tree[i]){//go left
			insert(a, (2*i)+1);
		}
		else{//go right
			insert(a, (2*i)+2);
		}
	}
	public void printInorder(){
		if(tree[0] == -1){//error checking
			System.out.println("Empty tree.");
		}
		else{//helper method
			printInorder(0);
		}
	}
	private void printInorder(int i){
		if(tree[i] == -1){//"empty" space, returns
			return;
		}
		if(tree[(2*i)+1] != -1){//checks the left children
			printInorder((2*i)+1);
		}
		System.out.println(tree[i]);//prints the value
		if(tree[(2*i)+2] != -1){//checks the right children
			printInorder((2*i)+2);
		}
	}
	public void printBreadthOrder(){
		for(int i = 0; i<tree.length; i++){//prints across siblings, not down the edges
			if(tree[i] != -1){//doesn't print any "empty" spaces
				System.out.println(tree[i]);
			}
		}
	}
	public int getDepth(int a){
		if(tree[0]==a){//empty tree
			return 0;
		}
		else{//helper method
			return getDepth(a, 0, 0);
		}
	}
	private int getDepth(int a, int i, int edges){
		if(tree[i] == -1 || i>= tree.length){//value not found, return -1
			return -1;
		}
		else if(tree[i] == a){//value found, return the number of edges it has gone down
			return edges;
		}
		else if(a<tree[i]){//value less than node, check its left children
			edges++;
			return getDepth(a, (2*i)+1, edges);
		}
		else{//value greater than node, check its right children
			edges++;
			return getDepth(a, (2*i)+2, edges);
		}
	}
}