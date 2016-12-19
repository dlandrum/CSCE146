//This class brought to you by Don Landrum
import java.util.Random;
public class SearchTester {
	public static void main(String[] args) {
		Random r = new Random();
		int linearSum = 0;
		int binarySum = 0;
		System.out.println("Welcome to the Search Tester");
		for(int i = 0; i<20; i++){ //20 tests of the separate searches
			int value = r.nextInt(1000); //desired value
			int [] theArray = ArrayGen(); //creates a sorted but randomly populated array
			System.out.println("Searching using the linear search");
			int linear = Linear(theArray, value); //prints out whether the value was found and returns the number of checks
			System.out.println("Searching using the binary search");
			int binary = Binary(theArray, value, 0, 999, 0); //prints out whether the value was found and returns the number of checks
			System.out.println("Linear Checks: "+linear); 
			System.out.println("Binary Checks: "+binary);
			linearSum = linearSum+linear; //adds the number of checks to the respective sums
			binarySum = binarySum+binary;
			System.out.println("");
		}
		System.out.println("The average number of checks for 20 trials were: ");
		System.out.println("Linear Search "+(linearSum/20)); //averages the linear count
		System.out.println("Binary Search "+(binarySum/20)); //averages the binary count
	}
	public static int [] ArrayGen(){
		Random r = new Random();
		int [] a = new int [1000];
		for(int i = 0; i<a.length; i++){ //populates the random array
			a[i] = r.nextInt(1000);
		}
		boolean swapped = true; //bubble sort
	    int j = 0;
	    int temp = 0;
	    while(swapped == true){
	    	swapped = false;
	    	j++;
	    	for (int i = 0; i < a.length - j; i++) {
	    		if (a[i] > a[i+1]) {
	    			temp = a[i];
	    			a[i] = a[i+1];
	    			a[i+1] = temp;
	    			swapped = true;
	    		}
	    	}
		}
	    return a; //returns the sorted random array
	}
	public static int Linear(int [] anArray, int aValue){
		int checks = 0;
		for(int i = 0; i<anArray.length; i++){
			if(anArray[i] == aValue){ //checks the index for the value
				System.out.println("Found!");
				i = anArray.length; //effectively stops the for loop
			}
			else{
				checks++; //keeps count of checks
			}
		}
		if(checks == 1000){
			System.out.println("Not found."); //if the value isn't contained, checks will equal 1000
		}
		return checks; //return the number of checks
	}
	public static int Binary(int [] anArray, int aValue, int bottom, int top, int count){
		int mid = (bottom+top)/2;
		if(bottom > top){ //this means that the parameters are swapped and there are no numbers left to check
			System.out.println("Not found.");
			return count;
		}
		if(anArray[mid] == aValue){ //if the middle index contains the desired value
			count++;
			System.out.println("Found!");
			return count;
		}
		else if(anArray[mid] < aValue){ //only checks the upper half of the remaining values
			count++;
			return Binary(anArray, aValue, mid+1, top, count);
		}
		else{ //only checks the lower half of the remaining values
			count++;
			return Binary(anArray, aValue, bottom, mid-1, count);
		}
	}
}