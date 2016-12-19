//this class brought to you by Don Landrum
import java.util.*;
public class SortingComparison {
	public static void main(String[] args) {
		System.out.println("Welcome to the Sorting Comparison Machine. \n20 random arrays of size 1000 will be sorted by different methods. \nThe average number of checks will be counted for each method.");
		int bubbleChecks = 0;
		int selectionChecks = 0;
		int mergeChecks = 0;
		int quickChecks = 0;
		for(int i = 0; i<19; i++){ //tests the methods 19 times
			int [] a = ArrayGen();//creates a randomly populated array of size 1000
			int [] bubbleClone = a;//copies the array (still unsorted) 4 times
			int [] selectionClone = a;
			int [] mergeClone = a;
			int [] quickClone = a;
			bubbleChecks = bubbleChecks + BubbleSort(bubbleClone); //adds the number of checks to the current number of checks for each method
			selectionChecks = selectionChecks + SelectionSort(selectionClone);
			mergeChecks = mergeChecks + mergeSort(mergeClone, 0);
			quickChecks = quickChecks + quickSort(quickClone, 0, quickClone.length-1, 0);
		}
		int [] a = ArrayGen();//repeats the above for loop one more time
		int [] bubbleClone = a;
		int [] selectionClone = a;
		int [] mergeClone = a;
		int [] quickClone = a;
		System.out.println("To prove that each method works, here are some results from the last trial of each method.");
		bubbleChecks = bubbleChecks + BubbleSort(bubbleClone);
		System.out.println("Here is every fiftieth digit from the Bubble Sorted array:");
		for(int i = 0; i<1000; i+=50){//prints every fiftieth digit from the sorted array to prove that it is sorted
			System.out.println(bubbleClone[i]);
		}
		selectionChecks = selectionChecks + SelectionSort(selectionClone);
		System.out.println("Here is every fiftieth digit from the Selection Sorted array:");
		for(int i = 0; i<1000; i+=50){ //prints every fourty-ninth digit from the sorted array to prove that it is sorted
			System.out.println(selectionClone[i]);
		}
		mergeChecks = mergeChecks + mergeSort(mergeClone, 0);
		System.out.println("Here is every fiftieth digit from the Merge Sorted array:");
		for(int i = 0; i<1000; i+=50){//prints every fourty-eighth digit from the sorted array to prove that it is sorted
			System.out.println(mergeClone[i]);
		}
		quickChecks = quickChecks + quickSort(quickClone, 0, quickClone.length-1, 0);
		System.out.println("Here is every fiftieth digit from the Quick Sorted array:");
		for(int i = 0; i<1000; i+=50){//prints every fourty-seventh digit from the sorted array to prove that it is sorted
			System.out.println(quickClone[i]);
		}
		//prints the average results
		System.out.println("Over twenty trials, the average numbers of checks were:\nBubble sort: "+bubbleChecks/20+ "\nSelection sort: "+selectionChecks/20+"\nMerge sort: "+mergeChecks/20+"\nQuick sort: "+quickChecks/20);
	}
	public static int [] ArrayGen(){
		Random r = new Random();
		int [] a = new int [1000];
		for(int i = 0; i<a.length; i++){ //populates the random array
			a[i] = r.nextInt(1000);
		}
		return a;
	}
	public static int BubbleSort(int [] a){ 
		boolean done = false; 
		int checks = 0;
		while(done == false){
			done = true;
			for(int i = 0; i<a.length-1;i++){ 
				checks++; //adds one to the number of checks performed
				if(a[i]>a[i+1]){ //if at least one swap occurs, the while loop repeats
					int temp = a[i];
					a[i] = a[i+1];
					a[i+1] = temp;
					done = false;
				}
			}
		}
		return checks;
	}
	public static int SelectionSort(int []a){
		int checks = 0;
		for(int i = 0; i<a.length; i++){//i is where the smallest number should be
			int smallestIndex = i;
			for(int j = i; j<a.length; j++){//this for loop checks through the array
				checks++;//this keeps track of the number of checks
				if(a[j]<a[smallestIndex]){
					smallestIndex = j;//smallestIndex is where the smallest number actually is
				}
			}
			int temp = a[i];//this swaps the values of i and smallestIndex
			a[i] = a[smallestIndex];
			a[smallestIndex] = temp;
		}
		return checks;
	}
	public static int mergeSort(int [] aList, int checks){
		int size = aList.length;
		if(size<2){//halt and return
			return checks;
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
		mergeSort(left,checks);//further splits the left half of the original matrix
		mergeSort(right,checks);//further splits the right half of the original matrix
		return merge(left,right,aList, checks);//merges everything back together
	}
	public static int merge(int [] left, int [] right, int [] a, int checks){
		int leftSize = left.length;
		int rightSize = right.length;
		int i = 0;//left array index
		int j = 0;//right array index
		int k = 0;//finished array index
		while(i<leftSize && j<rightSize){//compares until end of one array
			checks++;//each time the while loop runs, one check is performed
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
		return checks;
	}
	public static int quickSort(int [] a, int left, int right, int checks){
		int i = left;//leftmost index
		int j = right;//rightmost index
		int pivot = a[left+(right-left)/2];//sets the pivot point to the middle of the array
		while(i<=j){
			while(a[i]<pivot){//moves forward until something is out of place
				checks++;//check increases at each iteration
				i++; //correct position, move forward
			}
			while(a[j]>pivot){//moves backwards until something is out of place
				checks++;//check increases at each iteration
				j--; //correct position, move backward
			}
			if(i<=j){//swaps the two out of place values
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
				j--;
			}
		}
		if(left<j){//further sorts the left side
			quickSort(a, left, j, checks);
		}
		if(i<right){//further sorts the right side
			quickSort(a, i, right, checks);
		}
		return checks;
	}
}