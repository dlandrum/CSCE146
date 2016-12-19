//This class brought to you by Don Landrum
import java.util.*;
public class SheepHeapDriver {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r = new Random();
		SheepHeap sheeps = new SheepHeap();
		System.out.println("Adding 15 sheep");
		for(int i = 1; i<16; i++){//adds 15 sheep
			int random = r.nextInt(99)+1;//between 1 and 99, inclusive
			sheeps.addSheep("Sheep"+i, random);
			System.out.println("Sheep"+i+", "+random);
		}
		System.out.println();
		System.out.println("Removing 5 sheep");
		for(int i = 0; i<5; i++){//deletes 5 sheep
			System.out.println(sheeps.deleteSheep().toString());
		}
		System.out.println();
		System.out.println("Sheep Roll Call:");
		sheeps.sheepRollCall();//sheep roll call
		System.out.println();
		System.out.println("Sheep Heap Sort:");
		sheeps.sheepHeapSort();//sheep heap sort
	}
}