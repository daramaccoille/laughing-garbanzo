/**
 * 
 */
package Revision;

import java.util.Random;
import java.util.Scanner;

/**
 * @author Dara Mac Coille
 * @version 30/10/2023
 */
public class PubQuiz {

	/**
	 * @param args for main 
	 */
	public static void main(String[] args) {
		// Declare the questions and answers
		String[] jokeQuestions = { "Largest plane ? ", "Worse song ever ? ", "Capital of Peru?",
		"Funniest Lecturer ?" };
		String[] jokeAnswers = { "Aerflot777", "Think Twice", "Lima", "Matthew" };
		
		// Print header
		System.out.println("General knowledge quiz....");
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		boolean nextQuestion=true;
		
		// Do while loop to collect and print answers and questions
		// with the random library. equalsIgnoreCase for Strings
		do {
			
			int question = random.nextInt(jokeQuestions.length);
			System.out.println(jokeQuestions[question]);
			if (jokeAnswers[question].equalsIgnoreCase(scanner.nextLine())) {
				System.out.println("Well done");
			}
			else {
				System.out.println("Sorry, would you believe"
						+ " it was "+jokeAnswers[question]);
			}
			System.out.println("Another Question (Y or N)");
			if (scanner.nextLine().equalsIgnoreCase("N")) {
				nextQuestion=false;
				System.out.println("Thanks for playing");
				break;
			}
		} while (nextQuestion==true);
		

	}

}
