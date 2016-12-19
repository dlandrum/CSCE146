//This class brought to you by Don Landrum
import java.util.Random;
public class CircularLinkedListTester extends CircularLinkedList {
	public static void main(String[] args) {
		Random r = new Random();
		CircularLinkedList aList = new CircularLinkedList();//the controlling player
		CircularLinkedList bList = new CircularLinkedList();//the controlling player's varying opponents
		int [] wins = new int [10];//to keep track of each player's wins
		int [] losses = new int [10];//to keep track of each player's losses
		int [] ties = new int [10];//to keep track of each player's ties
		for(int i = 0; i<10; i++){
			aList.insertNodeAfterCurrent(i);//fills each linked list with players 0-9
			bList.insertNodeAfterCurrent(i);
		}
		aList.goToNext();//sets current at 0
		bList.goToNext();//sets current at 1
		bList.goToNext();
		System.out.println("Welcome to the Rock Paper Scissors Tournament. \nWe have 10 players. Let's begin!");
		while(aList.getDataAtCurrent() != bList.getDataAtCurrent()){ //this loop plays the first 9 games with 0 as the first player and the other nine players as the opponent
			int p1turn = r.nextInt(3);
			int p2turn = r.nextInt(3);
			switch (p1turn){
			case 0:
				System.out.println(aList.getDataAtCurrent()+" uses rock");
				break;
			case 1:
				System.out.println(aList.getDataAtCurrent()+" uses paper");
				break;
			case 2:
				System.out.println(aList.getDataAtCurrent()+" uses scissors");
				break;
			default:
				System.out.println("Error in random generator");
				break;
			}
			switch (p2turn){
			case 0:
				System.out.println(bList.getDataAtCurrent()+" uses rock");
				break;
			case 1:
				System.out.println(bList.getDataAtCurrent()+" uses paper");
				break;
			case 2:
				System.out.println(bList.getDataAtCurrent()+" uses scissors");
				break;
			default:
				System.out.println("Error in random generator");
				break;
			}
			if((p1turn == 0 && p2turn == 1) ||(p1turn == 1 && p2turn == 2) || (p1turn == 2 && p2turn == 0)){
				System.out.println(bList.getDataAtCurrent()+" wins!");
				wins[bList.getDataAtCurrent()]++;
				losses[aList.getDataAtCurrent()]++;
			}
			else if((p1turn == 1 && p2turn == 0) ||(p1turn == 2 && p2turn == 1) || (p1turn == 0 && p2turn == 2)){
				System.out.println(aList.getDataAtCurrent()+" wins!");
				wins[aList.getDataAtCurrent()]++;
				losses[bList.getDataAtCurrent()]++;
			}
			else if((p1turn == 0 && p2turn == 0) ||(p1turn == 1 && p2turn == 1) || (p1turn == 2 && p2turn == 2)){
				System.out.println("Tie!");
				ties[aList.getDataAtCurrent()]++;
				ties[bList.getDataAtCurrent()]++;
			}
			else{
				System.out.println("Error in victory checking");
			}
			bList.goToNext();
		}
		aList.goToNext();
		bList.goToNext();
		bList.goToNext();
		while(aList.getDataAtCurrent() != 0){ //this loop allows for the remaining 81 games to be played
		while(aList.getDataAtCurrent() != bList.getDataAtCurrent()){ //this loop plays 9 games at a time, with the first player changing at the end of each loop
			int p1turn = r.nextInt(3);
			int p2turn = r.nextInt(3);
			switch (p1turn){
			case 0:
				System.out.println(aList.getDataAtCurrent()+" uses rock");
				break;
			case 1:
				System.out.println(aList.getDataAtCurrent()+" uses paper");
				break;
			case 2:
				System.out.println(aList.getDataAtCurrent()+" uses scissors");
				break;
			default:
				System.out.println("Error in random generator");
				break;
			}
			switch (p2turn){
			case 0:
				System.out.println(bList.getDataAtCurrent()+" uses rock");
				break;
			case 1:
				System.out.println(bList.getDataAtCurrent()+" uses paper");
				break;
			case 2:
				System.out.println(bList.getDataAtCurrent()+" uses scissors");
				break;
			default:
				System.out.println("Error in random generator");
				break;
			}
			if((p1turn == 0 && p2turn == 1) ||(p1turn == 1 && p2turn == 2) || (p1turn == 2 && p2turn == 0)){
				System.out.println(bList.getDataAtCurrent()+" wins!");
				wins[bList.getDataAtCurrent()]++;
				losses[aList.getDataAtCurrent()]++;
			}
			else if((p1turn == 1 && p2turn == 0) ||(p1turn == 2 && p2turn == 1) || (p1turn == 0 && p2turn == 2)){
				System.out.println(aList.getDataAtCurrent()+" wins!");
				wins[aList.getDataAtCurrent()]++;
				losses[bList.getDataAtCurrent()]++;
			}
			else if((p1turn == 0 && p2turn == 0) ||(p1turn == 1 && p2turn == 1) || (p1turn == 2 && p2turn == 2)){
				System.out.println("Tie!");
				ties[bList.getDataAtCurrent()]++;
				ties[aList.getDataAtCurrent()]++;
			}
			else{
				System.out.println("Error in victory checking");
			}
			bList.goToNext();
		}
		aList.goToNext();
		bList.goToNext();
		bList.goToNext();
		}
		System.out.println("The tournament is over and here are the results:");
		for(int i = 0; i<10; i++){ //this loop prints out the results of the tournament by displaying the contents of the arrays
			System.out.println("Name: "+aList.getDataAtCurrent()+" Wins "+wins[i]+" Losses "+losses[i]+" Ties "+ties[i]);
			aList.goToNext();
		}
	}
}