import java.util.Random;
import java.util.Scanner;
public class TicTacToe {
//This class brought to you by Don Landrum
	static boolean compWin = false;//taking these variables outside the main method makes them global
	static boolean playWin = false;
	static boolean draw = false;
	static boolean negative = false;
	public static void main(String[] args) {
		char [][] board = new char [8][14];//creates the printable board
		int [] plays = new int [9];//creates a simple version of the board
		String [] names = new String[100];//creates the record of winner names
		int [] scores = new int[100];//creates the record of winner scores
		System.out.println("Welcome to tic tac toe. How many games can you win in a row?");
		boolean kingBool = false;//keeps the game running until it is exited
		while(kingBool == false){
		int wins = 0;
		Scanner keyboard = new Scanner(System.in);
		resetBoard(board, plays);//empties the board
		drawBoard(board);//draws the board
		while(compWin == false && playWin == false){//while neither player has won
			playerTurn(board, keyboard, plays, compWin);//player takes a turn
			drawBoard(board);
			if(checkForWin(compWin, playWin, negative, plays) == true){//if someone has won just now, it must have been the player
					wins++;
					System.out.println("The computer demands a rematch");
					resetBoard(board, plays);
					drawBoard(board);
					playWin = false;//reset booleans
					compWin = false;
					draw = false;
					playerTurn(board, keyboard, plays, compWin);
					drawBoard(board);
			}
			else if(checkForDraw(plays, draw, negative) == true){//if the board is full but no one has won
				System.out.println("The game is a draw");
				System.out.println("The computer demands a rematch");
				resetBoard(board, plays);
				drawBoard(board);
				playWin = false;//reset booleans
				compWin = false;
				draw = false;
				playerTurn(board, keyboard, plays, compWin);
				drawBoard(board);
			}
			computerTurn(board, plays);//computer takes a turn
			drawBoard(board);
			if(checkForWin(compWin, playWin, negative, plays) == true){//if someone has won just now, it must have been the computer
				break;
				//I don't need to check for a draw here because only compWin is possible due to the odd number of game spaces
			}
		}
		System.out.println("Game is over but you won "+wins+" in a row");
		System.out.println("Enter your name to record your score");
		String name = keyboard.next();
		for(int i = 0; i<100; i++){//records the name and score to two similar arrays
			if(names[i] == null){
				names[i]= name;
				scores[i] = wins;
				break;
			}
		}
		for(int i = 0; i<100; i++){//prints out the name and score arrays
			if(names[i] != null){
				System.out.println(names[i] +" "+scores[i]);
			}
		}
		keyboard.nextLine();
		System.out.println("Would you like to play again? Yes or no");
		String answer = keyboard.nextLine();
		if(answer.equalsIgnoreCase("yes")){//resets the booleans to keep the game going
			compWin = false;
			playWin = false;
			draw = false;
			negative = false;
			kingBool = false;
		}
		else{
			System.out.println("Goodbye!");
			kingBool = true;//effectively quits the game
		}
		}
	}
	public static void resetBoard(char [][] aBoard, int [] aPlays){
		for(int i = 0; i<8; i+=2)
		{
			for(int j = 0; j<14; j++)
			{
				aBoard[i][j] = ' ';
			}
		}
		for(int i = 1; i<8; i+=2)
		{
			for(int j = 0; j<14; j++)
			{
				aBoard[i][j] = '_';
			}
		}
		for(int i = 0; i<8; i+=2)//draws boundaries
		{
			aBoard[i][1]= '|';
			aBoard[i][5] = '|';
			aBoard[i][9] = '|';
			aBoard[i][13] = '|';
		}
		aBoard[2][0] = '0';//draws headers
		aBoard[4][0] = '1';
		aBoard[6][0] = '2';
		aBoard[0][3] = '0';
		aBoard[0][7] = '1';
		aBoard[0][11] = '2';
		for(int i = 0; i<aPlays.length; i++)//clears game pieces
		{
			aPlays[i] = 0;
		}
	}	
	public static void drawBoard(char [][] aBoard){
		for(int i = 0; i<8; i++)// prints entire board
		{
			for(int j = 0; j<14; j++)
			{
				System.out.print(aBoard[i][j]);
			}
			System.out.println("");
		}
	}
	public static void playerTurn(char [][] aBoard, Scanner keyboard, int [] aPlays, boolean compWin){
		System.out.println("Enter the coordinates (row then column) to place an X or enter a negative number to quit");
		int aRow = keyboard.nextInt();//takes inputs
		int aColumn = keyboard.nextInt();
		int aPlay = -1;
		if(aRow<0 || aColumn<0){//error checking
			System.out.println("The computer wins \nGoodbye!");
			System.exit(0);;
		}
		if(aRow == 0 && aColumn == 0){//assign game piece decision to simple board array
			aPlay = 0;
		}
		else if(aRow == 1 && aColumn == 0){
			aPlay = 1;
		}
		else if(aRow == 2 && aColumn == 0){
			aPlay = 2;
		}
		else if(aRow == 0 && aColumn == 1){
			aPlay = 3;
		}
		else if(aRow == 0 && aColumn == 2){
			aPlay = 4;
		}
		else if(aRow == 1 && aColumn == 1){
			aPlay = 5;
		}
		else if(aRow == 1 && aColumn == 2){
			aPlay = 6;
		}
		else if(aRow == 2 && aColumn == 1){
			aPlay = 7;
		}
		else if(aRow == 2 && aColumn == 2){
			aPlay = 8;
		}
		else{
			//reask for points if invalid input
			System.out.println("Invalid input, please try again");
			playerTurn(aBoard, keyboard, aPlays, compWin);
			return;
		}
		if(aPlays[aPlay] == 0){
			aPlays[aPlay] = 1;
		}
		else{
			//reask for points if space is already taken
			System.out.println("Invalid input, please try again");
			playerTurn(aBoard, keyboard, aPlays, compWin);
			return;
		}
		switch(aRow){ //assign game piece decision to bigger board picture
		case 0:
			aRow = 2;
			break;
		case 1:
			aRow = 4;
			break;
		case 2:
			aRow = 6;
			break;
		default:
			System.out.println("Goodbye!");
			System.exit(0);
			break;
		}
		switch(aColumn){
		case 0:
			aColumn = 3;
			break;
		case 1:
			aColumn = 7;
			break;
		case 2:
			aColumn = 11;
			break;
		default:
			System.out.println("Goodbye!");
			System.exit(0);
			break;
		}
		aBoard[aRow][aColumn] = 'X';//place character on board
	}
	public static void computerTurn(char [][] aBoard, int [] aPlays){
		System.out.println("Computer's Turn");
		boolean repeat = false;//keeps the loop running until a spot is found
		while(repeat == false){
		Random r = new Random();
		int aRow = r.nextInt(3);//random integers to populate board
		int aColumn = r.nextInt(3);
		int aPlay = -1;
		if(aRow == 0 && aColumn == 0){//assigns game piece to simple array
			aPlay = 0;
		}
		else if(aRow == 1 && aColumn == 0){
			aPlay = 1;
		}
		else if(aRow == 2 && aColumn == 0){
			aPlay = 2;
		}
		else if(aRow == 0 && aColumn == 1){
			aPlay = 3;
		}
		else if(aRow == 0 && aColumn == 2){
			aPlay = 4;
		}
		else if(aRow == 1 && aColumn == 1){
			aPlay = 5;
		}
		else if(aRow == 1 && aColumn == 2){
			aPlay = 6;
		}
		else if(aRow == 2 && aColumn == 1){
			aPlay = 7;
		}
		else if(aRow == 2 && aColumn == 2){
			aPlay = 8;
		}
		if(aPlays[aPlay] == 0){//assigns game piece to bigger board picture
			aPlays[aPlay] = 2;
			switch(aRow){
			case 0:
				aRow = 2;
				break;
			case 1:
				aRow = 4;
				break;
			case 2:
				aRow = 6;
				break;
			default:
				System.out.println("Error in random number generator!");
				System.exit(0);
				break;
			}
			switch(aColumn){
			case 0:
				aColumn = 3;
				break;
			case 1:
				aColumn = 7;
				break;
			case 2:
				aColumn = 11;
				break;
			default:
				System.out.println("Error in random number generator!");
				System.exit(0);
				break;
			}
			aBoard[aRow][aColumn] = 'O';//place character on board
			repeat = true;//breaks the loop
		}
		}
	}
	public static boolean checkForWin(boolean compWin, boolean playWin, boolean aNegative, int[]aPlays){
	if((aPlays[0] == 2) && (aPlays[3] == 2) && (aPlays[4] == 2)){//checks the various ways in which computer can win
		System.out.println("Computer wins");
		compWin = true;
		return compWin;//returns true if computer wins
	}
	else if((aPlays[1] == 2) && (aPlays[5] == 2) && (aPlays[6] == 2)){
		System.out.println("Computer wins");
		compWin = true;
		return compWin;
		}
	else if((aPlays[2] == 2) && (aPlays[7] == 2) && (aPlays[8] == 2)){
		System.out.println("Computer wins");
		compWin = true;
		return compWin;
		}
	else if((aPlays[0] == 2) && (aPlays[1] == 2) && (aPlays[2] == 2)){
		System.out.println("Computer wins");
		compWin = true;
		return compWin;
	}
	else if((aPlays[3] == 2) && (aPlays[5] == 2) && (aPlays[7] == 2)){
		System.out.println("Computer wins");
		compWin = true;
		return compWin;
	}
	else if((aPlays[4] == 2) && (aPlays[6] == 2) && (aPlays[8] == 2)){
		System.out.println("Computer wins");
		compWin = true;
		return compWin;
	}
	else if((aPlays[0] == 2) && (aPlays[5] == 2) && (aPlays[8] == 2)){
		System.out.println("Computer wins");
		compWin = true;
		return compWin;
	}
	else if((aPlays[2] == 2) && (aPlays[5] == 2) && (aPlays[4] == 2)){
		System.out.println("Computer wins");
		compWin = true;
		return compWin;
	}
	else if((aPlays[0] == 1) && (aPlays[1] == 1) && (aPlays[2] == 1)){//checks the various ways in which player can win
		System.out.println("Player wins");
		playWin = true;
		return playWin;//returns true if player wins
	}
	else if((aPlays[3] == 1) && (aPlays[5] == 1) && (aPlays[7] == 1)){
		System.out.println("Player wins");
		playWin = true;
		return playWin;
	}
	else if((aPlays[4] == 1) && (aPlays[6] == 1) && (aPlays[8] == 1)){
		System.out.println("Player wins");
		playWin = true;
		return playWin;
	}
	else if((aPlays[0] == 1) && (aPlays[3] == 1) && (aPlays[4] == 1)){
		System.out.println("Player wins");
		playWin = true;
		return playWin;
	}
	else if((aPlays[1] == 1) && (aPlays[5] == 1) && (aPlays[6] == 1)){
		System.out.println("Player wins");
		playWin = true;
		return playWin;
	}
	else if((aPlays[2] == 1) && (aPlays[7] == 1) && (aPlays[8] == 1)){
		System.out.println("Player wins");
		playWin = true;
		return playWin;
	}
	else if((aPlays[0] == 1) && (aPlays[5] == 1) && (aPlays[8] == 1)){
		System.out.println("Player wins");
		playWin = true;
		return playWin;
	}
	else if((aPlays[2] == 1) && (aPlays[5] == 1) && (aPlays[4] == 1)){
		System.out.println("Player wins");
		playWin = true;
		return playWin;
	}
	else{
		aNegative = false;
		return aNegative;//returns false if neither player nor computer wins
	}
	}
	public static boolean checkForDraw(int[]aPlays, boolean aDraw, boolean aNegative){
		if((aPlays[0] != 0) && (aPlays[1] != 0) && (aPlays[2] != 0) && (aPlays[3] != 0) && (aPlays[4] != 0) && (aPlays[5] != 0) && (aPlays[6] != 0) && (aPlays[7] != 0) && (aPlays[8] != 0)){
			aDraw = true;
			return aDraw;
		}
		else{
			return aNegative;
		}
	}
}