import java.util.Scanner;
import java.util.Random;
public class MultiDimensionalArray {
//This class brought to you by Don Landrum
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		Random r = new Random();
		System.out.println("Enter the desired size of the matrix");
		int size = keyboard.nextInt();
		if(size<1) //error checking
		{
			System.out.println("You can't do that");
			System.exit(0);
		}
		int[][] first = new int[size][size]; //create the first matrix
		int[][] second = new int[size*2][size*2]; //create the second matrix
		for(int i = 0; i<size; i++){ //fill the first matrix
			for(int j = 0; j<size; j++){
				first[i][j] = r.nextInt(10);
			}
		}
		for(int k = 0; k<size; k++){ //fill the second matrix
			for(int l = 0; l<size; l++){
				second[2*k][2*l] = first[k][l];
				second[2*k+1][2*l]= first[k][l];
				second[2*k][2*l+1]= first[k][l];
				second[2*k+1][2*l+1]= first[k][l];
			}
		}
		System.out.println("This is the matrix");
		for(int a = 0; a<size; a++){ //print the first matrix
			for(int b = 0; b<size; b++){
				System.out.print(first[a][b] + " ");
			}
			System.out.println("");
		}
		System.out.println("This is the doubled matrix");
		for(int c = 0; c<size*2; c++){ //print the second matrix
			for(int d = 0; d<size*2; d++){
				System.out.print(second[c][d] + " ");
			}
			System.out.println("");
		}
		keyboard.close();
	}
}
/*
Notes:
Learn how and why we use data structures. Dry subject, but JJ will "lubricate" it for us.
Efficiency is a bigger deal in this class. He is not giving us exact code anymore. This class isn't
about Java, it's about data structures. COMMENT MY CODE. 
Declaring an array: type[] name = new type [amount];
multidimensional array = matrix. Arrays are fixed in memory. The size of an array cannot change.
*/