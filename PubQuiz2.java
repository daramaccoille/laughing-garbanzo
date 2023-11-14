package week6_reading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class PubQuiz2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Declare the questions and answers
		List<String> questions= new ArrayList<String>();
		List<String> answers= new ArrayList<String>();
				String[] jokeQuestions = { "Largest plane ? ", "Worse song ever ? ", "Capital of Peru?",
				"Funniest Lecturer ?" };
				for (String string : jokeQuestions) {
					questions.add(string);
				}
				String[] jokeAnswers = { "Aerflot777", "Think Twice", "Lima", "Matthew" };
				for (String string : jokeAnswers) {
					answers.add(string);
				}
				// Print header
				System.out.println("General knowledge quiz....");
				Scanner scanner = new Scanner(System.in);
				Random random = new Random();
				boolean nextQuestion=true;
				
				// Do while loop to collect and print answers and questions
				// with the random library. equalsIgnoreCase for Strings
				do {
					
					int intQuestion = random.nextInt(questions.size());
					String strQuestion = questions.get(intQuestion);
					System.out.println(strQuestion);
					String strAnswer = answers.get(intQuestion);
					if (strAnswer.equalsIgnoreCase(scanner.nextLine())) {
						System.out.println("Well done");
					}
					else {
						System.out.println("Sorry, would you believe"
								+ " it was "+jokeAnswers[intQuestion]);
					}
					questions.remove(intQuestion);
					answers.remove(intQuestion);
					System.out.println("Another Question (Y or N)");
					if (scanner.nextLine().equalsIgnoreCase("N")) {
						nextQuestion=false;
						System.out.println("Thanks for playing");
						break;
					}
				} while (nextQuestion==true&&questions.size()>0);
				

			
	}
public static boolean usedQuestionAnswer() {
	return true;
}
}
