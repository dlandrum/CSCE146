//This class brought to you by Don Landrum
import java.util.Scanner;
public class FearHashTable {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		PhobiaHashTable aTable = new PhobiaHashTable();
		System.out.println("Welcome to the fear hash table!");
		while(true){//keeps running until stopped
			System.out.println("Enter:\n1. To add a fear\n2. To remove a fear\n3. To look up a fear\n4. To print all fears\n5. To quit");
			int input = keyboard.nextInt();
			int endIt=0;
			switch (input){
			case 1:
				String garbage1 = keyboard.nextLine();//collecting garbage strings helps keyboard run smoothly
				System.out.println("What is the name of the phobia?");
				String aName = keyboard.nextLine();
				System.out.println("Describe the fear");
				String aDescription = keyboard.nextLine();
				aTable.add(aName, aDescription);//add a phobia
				break;
			case 2:
				String garbage2 = keyboard.nextLine();
				System.out.println("Which phobia do you want to remove?");
				String bName = keyboard.nextLine();
				System.out.println("Describe the fear");
				String bDescription = keyboard.nextLine();
				aTable.remove(bName, bDescription);//remove a phobia
				break;
			case 3:
				String garbage3 = keyboard.nextLine();
				System.out.println("Which phobia do you want to look up?");
				String cName = keyboard.nextLine();
				System.out.println(aTable.lookup(cName));//lookup a phobia
				break;
			case 4:
				aTable.printHashTable();//print the table
				break;
			default:
				endIt=1;
				break;
			}
			if(endIt!=0){//exit the while loop
				break;
			}
		}
		System.out.println("Goodbye!");
		keyboard.close();
	}
}