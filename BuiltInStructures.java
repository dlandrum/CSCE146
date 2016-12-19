//This class brought to you by Don Landrum
import java.util.*;
public class BuiltInStructures {
	public static void main(String[] args) {
		Random r = new Random();
		for(int count = 0; count<3; count++){
			ArrayList<Integer> aList = new ArrayList<Integer>(); //makes a new array list of type integer
			int size = r.nextInt(10);
			size = size+10;//makes the random size of the array list between 10 and 20
			System.out.println("Populating the Array List of size "+size);
			for(int i = 0; i<size; i++){//randomly populates the array list
				aList.add(r.nextInt(100));
			}
			System.out.println("This list contains");
			for(int i = 0; i<size; i++){//prints out the value at each index in the array list
				System.out.println(aList.get(i));
			}
			System.out.println("Sorting");
			int [] theList = new int [size];
			for(int i = 0; i<theList.length; i++){//copies the array list into a standard integer array
				theList[i] = aList.get(i);
			}
			mergeSort(theList);//sorts the integer array
			aList.clear();//clears the initial array list
			for(int i = 0; i<size; i++){//re-populates the array list with the now sorted values from the copy array
				aList.add(theList[i]);
			}
			System.out.println("Printing sorted numbers");
			for(int i = 0; i<size; i++){//prints the numbers in order
				System.out.println(aList.get(i));
			}
			System.out.println("Adding elements in the list to a queue");
			Queue<Integer> q = new LinkedList<Integer>();//creates a queue of type integer
			for(int i = 0; i<size; i++){//populates the queue from the array list
				q.add(aList.get(i)); //enqueue
			}
			System.out.println("Removing and Printing each element from the queue");
			while(q.isEmpty()==false){//dequeues and prints the queue
				System.out.println(q.remove()); //dequeue
			}
			System.out.println("Adding elements in the list to a stack");
			Stack<Integer> stack = new Stack<Integer>();//creates a stack of type integer
			for(int i = 0; i<size; i++){//pushes each value from the array list onto the stack
				stack.push(aList.get(i));
			}
			System.out.println("Removing and Printing each element from the stack");
			while(stack.isEmpty()==false){//pops each value off of the stack and prints
				System.out.println(stack.pop());
			}
		}
	}
	public static void mergeSort(int [] aList){
		int size = aList.length;
		if(size<2){//halt and return
			return;
		}
		int mid = size/2;
		int leftSize = mid;
		int rightSize = size-mid;
		int [] left = new int[leftSize];//creates an array as big as the left half of the original
		int [] right = new int[rightSize];//creates an array as big as the right half of the original
		for(int i = 0; i<mid; i++){//populates the left array with the corresponding values from the original
			left[i] = aList[i];
		}
		for(int i = mid; i<size; i++){//populates the right array with the corresponding values from the original
			right[i-mid] = aList[i];
		}
		mergeSort(left);//further splits the left half of the original matrix
		mergeSort(right);//further splits the right half of the original matrix
		merge(left,right,aList);//merges everything back together
	}
	public static void merge(int [] left, int [] right, int [] a){
		int leftSize = left.length;
		int rightSize = right.length;
		int i = 0;//left array index
		int j = 0;//right array index
		int k = 0;//finished array index
		while(i<leftSize && j<rightSize){//compares until end of one array
			if(left[i]<=right[j]){//if the left is less than or equal to the right, places the left in the final array and moves to the next index
				a[k] = left[i];
				i++;
				k++;
			}
			else{//if the right is bigger than the left, places the right in the final array and moves to the next index
				a[k] = right[j];
				j++;
				k++;
			}
		}
		//fills in rest of final array
		while(i<leftSize){
			a[k] = left[i];
			i++;
			k++;
		}
		while(j<rightSize){
			a[k] = right[j];
			j++;
			k++;
		}
	}
}