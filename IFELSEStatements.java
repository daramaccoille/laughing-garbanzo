package week2;

// Imports for the user input and some error handling
import java.util.Scanner;
import java.util.InputMismatchException;
//import java.lang.RuntimeException;

public class IFELSEStatements {

	public static void main(String[] args) {


//Initialize the scanner
		Scanner scanner = new Scanner(System.in);

// Create the validFinalMark flag
boolean validFinalMark = false;
while (!validFinalMark) {
	try {
		// Ask the user to enter a valid final score
		System.out.println("Please enter a final mark for a Masters student (between 0 – 100).");
		// Store the value as an integer
		int finalMark = scanner.nextInt();

		// If statements for the logical classification
		if (finalMark>0 && finalMark<50) 
		{System.out.println("Classification: Fail");validFinalMark=true;break;}
		if (finalMark>=50 && finalMark<60) 
		{ System.out.println("Classification: Pass");validFinalMark=true;break;}
		if (finalMark>=60 && finalMark<70) 
		{System.out.println("Classification: Merit");validFinalMark=true;break;}
		if (finalMark>=70 && finalMark<=100) 
		{System.out.println("Classification: Distinction");validFinalMark=true;break;}

		// Invalid user input partially dealt with
		else {
			System.out.println("This is not a valid final mark!");
			
		}
		// Invalid user input dealt with again
	} catch (InputMismatchException ex) {
		System.out.println("Invalid user input, Input mismatch with mark");
		break;
	}	
	catch (IllegalStateException exc) {
		System.out.println("Invalid user input, Runtime illegal State exception possible scanner issue.");
		
	}	
	
}
scanner.close();
System.out.println("Thanks for entering the mark. Goodbye");
	}
}


