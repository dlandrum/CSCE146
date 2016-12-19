//This class brought to you by Don Landrum
public class MinIntHeapDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinIntHeap<Integer> a = new MinIntHeap<Integer>();
		System.out.println("Int Min Heap Tester\nPopulating Heap with Values");
		int [] arr = {21,37,49,11,23,1,13,16,33,17};//numbers given by JJ
		for(int i = 0; i<arr.length; i++){
			a.insert(arr[i]);//inserts them all
			System.out.println(arr[i]);
		}
		System.out.println("Printing Heap");
		a.print();//prints in breadth order
		System.out.println("Testing Heap Sort");
		a.heapSort();//prints in order
		System.out.println();
		System.out.println("Removing an element");
		int b = a.delete();//removes the root
		System.out.println("The element removed is "+b+" and the heap is now:");
		a.print();//prints in breadth order
	}

}
