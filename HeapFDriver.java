//This class brought to you by Don Landrum
import java.util.Scanner;
public class HeapFDriver {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		HeapF aHeap = new HeapF();//creates instance of heap
		System.out.println("Welcome to the F Word Sorter! \nEnter words or phrases and it will sort from least number of F's to most number of F's.\nEnter \"Sort\" to finish and sort.");
		while(true){
			String anInput = keyboard.nextLine();
			if(anInput.trim().equalsIgnoreCase("sort")){
				break;
			}
			else{
				aHeap.insert(anInput);//adds inputs
			}
		}
		System.out.println("\nThe sorted phrases are: ");
		aHeap.heapSort();//prints the sorted heap
		System.out.println("Goodbye!");
		keyboard.close();
	}
}