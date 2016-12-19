//This class brought to you by Don Landrum
import java.util.Scanner;
public class ReversePolish extends StackArray {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		StackNotes aStack = new StackNotes(); //creates the stack
		boolean quit = false;
		while(quit == false){
			System.out.println("Enter a reverse polish expression or \"quit\" to quit");
			String [] inputs = new String[100]; 
			String input = keyboard.nextLine().trim();
			Scanner aScanner = new Scanner(input);
			for(int i = 0; i<100; i++){
				try{//this fills the String array with each input split up by white space
					inputs[i] = aScanner.next();
					if(inputs[i].equalsIgnoreCase("quit")){
						System.out.println("Goodbye!");
						quit = true;
						System.exit(0);
					}
				}
				catch(Exception e){//this allows the rest of the array to remain null
					
				}
			}
			aScanner.close();
			for(int j=0; j<100; j++){
				boolean test = true;
				try{//if the input is an integer, it is parsed and pushed onto the stack
					int inputA = Integer.parseInt(inputs[j]);
					aStack.push(inputA);
				}
				catch (Exception e){ //if the input is not an integer, this exception is caught and test is turned to false
					test = false;
				}
				if(test ==false){
					try{
						if(inputs[j].equals("+")){//this adds the two most recent integers
							int c = (int) aStack.pop();
							int d = (int) aStack.pop();
							aStack.push((c+d));
						}
						else if(inputs[j].equals("-")){//this subtracts them
							int l = (int) aStack.pop();
							int f = (int) aStack.pop();
							aStack.push((f-l));
						}
						else if(inputs[j].equals("*")){//this multiplies them
							int g = (int) aStack.pop();
							int h = (int) aStack.pop();
							aStack.push((g*h));
						}
						else if(inputs[j].equals("/")){//this divides them 
							int k = (int) aStack.pop();
							int m = (int) aStack.pop();
							if(k == 0){//doesn't allow user to divide by zero
								System.out.println("You cannot divide by zero");
								System.exit(0);
							}
							else{
								aStack.push((m/k));
							}
						}
						else{//error message if an unacceptable input is entered
							j = 101;
							System.out.println("Error");
							quit = true;
						}
					}
					catch(Exception p){//if something went wrong above, this error message is thrown because it was not properly formatted
						System.out.println("This was not properly formatted");
						j = 70;
					}
				}
				if(inputs[j+1]==null){//effectively stops the loop if the next input is null
					j = 101;
				}
			}
			int ab = 0;
			try{//if two integers can be popped off, then it is not properly formatted
				ab = (int) aStack.pop();
				int bc = (int) aStack.pop();
				System.out.println("This was not properly formatted");
			}
			catch(Exception o){//otherwise, the popped integer is my answer
				System.out.println(ab);
			}
		}
		keyboard.close();
	}
}