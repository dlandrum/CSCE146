//This class brought to you by Don Landrum
public class ShapeBST <T extends Shape> {//forces everything to have .getArea() method
	private class Node{
		private Node left;
		private Node right;
		private Shape data;
		public Node(){//default constructor
			left = null;
			right = null;
			data = null;
		}
		public Node(Shape aData){//parameterized constructor
			left = null;
			right = null;
			data = aData;
		}
	}
	private Node root;
	public ShapeBST(){
		root = null;//default constructor
	}
	public void insert(Shape aData){
		if(root == null){//insert shape at root
			Node bNode = new Node(aData);
			root = bNode;
		}
		else{
			insert(aData, root);//helper method
		}
	}
	private Node insert(Shape aData, Node aNode){
		if(aNode == null){//insert shape
			Node bNode = new Node(aData);
			aNode = bNode;
		}
		else if(aData.getArea()<aNode.data.getArea()){//go left
			aNode.left = insert(aData, aNode.left);
		}
		else{//go right
			aNode.right = insert(aData, aNode.right);
		}
		return aNode;//connects all of the family relationships
	}
	public void delete(double anArea){
		root = delete(anArea, root);//helper method
	}
	private Node delete(double anArea, Node aNode){
		if(aNode == null){//not found
			return null;
		}
		if(anArea == aNode.data.getArea()){//found it!
			System.out.print(aNode.data.toString());//print what we're deleting
			if(aNode.left == null && aNode.right == null){//no kids
				return null;
			}
			else if(aNode.left == null){//right child
				return aNode.right;
			}
			else if(aNode.right == null){//left child
				return aNode.left;
			}
			else{//both children
				Node temp = aNode;
				aNode = findSmallValue(aNode.right);
				aNode.right = killSmall(temp.right);
				aNode.left = temp.left;
			}
		}
		else if(anArea< aNode.data.getArea()){//look left
			aNode.left = delete(anArea, aNode.left);
		}
		else{//look right
			aNode.right = delete(anArea, aNode.right);
		}
		return aNode;
	}
	private Node killSmall(Node aNode){
		if(aNode == null){//error checking
			return null;
		}
		if(aNode.left == null){//found smallest
			return aNode.right;//deletes it
		}
		else{//keep looking
			aNode.left = killSmall(aNode.left);
			return aNode;
		}
	}
	private Node findSmallValue(Node aNode){
		if(aNode.left == null){//if this is the smallest, return it
			return aNode;
		}
		else{//keep looking
			return findSmallValue(aNode.left);
		}
	}
	public void preprint(){
		preprint(root);//helper method
	}
	private void preprint(Node aNode){
		if(aNode == null)//error checking
			return;
		System.out.println(aNode.data.toString());//print
		if(aNode.left != null)//explore left
			preprint(aNode.left);
		if(aNode.right != null)//explore right
			preprint(aNode.right);
		return;
	}
	public void inprint(){
		inprint(root);//helper method
	}
	private void inprint(Node aNode){
		if(aNode == null)//error checking
			return;
		if(aNode.left != null)//explore left
			inprint(aNode.left);
		System.out.println(aNode.data.toString());//print
		if(aNode.right != null)//explore right
			inprint(aNode.right);
		return;
	}
	public void postprint(){
		postprint(root);//helper method
	}
	private void postprint(Node aNode){
		if(aNode == null)//error checking
			return;
		if(aNode.left != null)//explore left
			postprint(aNode.left);
		if(aNode.right != null)//explore right
			postprint(aNode.right);
		System.out.println(aNode.data.toString());//print
		return;
	}
	public double maxArea(){
		return maxArea(root);//helper method
	}
	private double maxArea(Node aNode){
		if(aNode.right == null){//if this is the max node, return it
			return aNode.data.getArea();
		}
		else{//keep looking
			return maxArea(aNode.right);
		}
	}
	public void deleteAbove(double aDouble){
		while(maxArea(root)>= aDouble){//if there is at least one node in violation
			deleteAbove(aDouble, root);//helper method
		}
	}
	private Node deleteAbove(double aDouble, Node aNode){
		if(aNode == null){//no such values
			return null;
		}
		if(aNode.data.getArea()>aDouble){//found the first one greater than the input
			return aNode.left;//deletes it and its right children
		}
		else{//keep looking
			aNode.right = deleteAbove(aDouble, aNode.right);
			return aNode;
		}
	}
}