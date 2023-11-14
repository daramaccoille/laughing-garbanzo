package week6_reading;

import java.util.Random;
import java.util.Scanner;

public class pubQuiz3 {

	public static void main(String[] args) {

		String[] jokeQuestions = { "Largest plane ? ", "Worse song ever ? ", "Capital of Peru?",
				"Funniest Lecturer ?" };
		String[] jokeAnswers = { "Aerflot777", "Think Twice", "Lima", "Matthew" };

		// Print header
		System.out.println("General knowledge quiz....");
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		boolean nextQuestion = true;
		int questionCount = jokeQuestions.length;
		do {
			int intQuestion = random.nextInt(jokeQuestions.length);
			if (jokeQuestions[intQuestion].length() > 0) {
				System.out.println(jokeQuestions[intQuestion]);
				String strAnswer = jokeAnswers[intQuestion];
				if (strAnswer.equalsIgnoreCase(scanner.nextLine())) {
					System.out.println("Well done");
				} else {
					System.out.println("Sorry, would you believe" + " it was " + jokeAnswers[intQuestion]);
				}
				jokeQuestions[intQuestion] = "";
				jokeAnswers[intQuestion] = "";
				System.out.println("Another Question (Y or N)");
				if (scanner.nextLine().equalsIgnoreCase("N")) {
					nextQuestion = false;
					System.out.println("Thanks for playing");
					break;
				}
			}
			questionCount -= 1;
		} while (nextQuestion == true && questionCount > 0);
System.out.println("No questions left...Thanks for playing");
	}

}
