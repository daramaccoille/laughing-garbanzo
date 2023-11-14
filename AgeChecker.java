package week2;
import java.util.Scanner;
public class AgeChecker {

	public static void main(String[] args) {
	// Ask the user for their age
		System.out.println("Please enter you age (e.g. 47) : ");
		
	
		boolean validInput = false;
		while (!validInput) {
			// Initialize the scanner and collect input
			Scanner scanner = new Scanner(System.in);
	// Try to get valid input
			try {
				
				int age = scanner.nextInt();
	// If the user is over 17 we can ask for a name			
				if (age>17) {
					System.out.println("Thank you for entering an age greater than 17\n"
							+ "Please enter your name: ");
					
	// Create a new scanner to read the user's name				
					Scanner scanner1 = new Scanner(System.in);
					String name=""; 
					name= scanner1.nextLine();
					scanner1.close();
					System.out.println("Hi "+name+ " you are "+age);
					return;
				}
	// Check for age less than 1 			
				else {
					if (age<1) {
						System.out.println("Sorry, don't recognise your input "); return;}
					else{System.out.println("Too young to continue "); 
					return;}
				}
				 
	// Catch some incorrect user input			
			} catch (Exception ex) {
				System.out.println("Something was wrong with your input. Please restart the program : ");
				break;
			}
			finally {scanner.close();}
		}
		
		
	}

}
