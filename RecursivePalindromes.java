//This class brought to you by Don Landrum
import java.util.Scanner;
public class RecursivePalindromes {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter a word or phrase and I will determine whether it is a palindrome");
		String input = keyboard.nextLine();
		String modInput = "";
		for(int i = 0; i<input.length(); i++){ //remove all white space from the string
			if(input.charAt(i) != ' '){
				modInput = modInput+input.charAt(i);
			}
		}
		modInput = modInput.toLowerCase(); //format everything in lower case
		if(Palindrome(modInput) == true){ //if it is a palindrome
			System.out.println("The word/phrase \""+input+"\" is a palindrome");
		}
		else if(Palindrome(modInput) == false){ //if it is not a palindrome
			System.out.println("The word/phrase \""+input+"\" is not a palindrome");
		}
		keyboard.close();
	}
	public static boolean Palindrome(String aModInput){
		if(aModInput.length()<2 || aModInput == null){ //it is a palindrome
			return true;
		}
		else if(aModInput.charAt(0) == aModInput.charAt(aModInput.length()-1)){ //it is too big to tell and needs to be run again
			String bModInput = aModInput.substring(1, aModInput.length()-1);
			return Palindrome(bModInput);
		}
		else{ //it is not a palindrome
			return false;
		}
	}
}