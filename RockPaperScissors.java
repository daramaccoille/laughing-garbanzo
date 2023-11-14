/**
 * 
 */
package week6_reading;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import javax.swing.text.StyledEditorKit.ForegroundAction;

/**
 * @author Dara Mac Coille
 * @version Nov 4, 2023
 */
public class RockPaperScissors {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		String[] answers = new String[] { "Rock", "Paper", "Scissors" };
		Scanner scanner = new Scanner(System.in);
		// Ask user to change rounds
		int rounds = 5;
		int playerScore = 0;
		int computerScore = 0;
		int drawScore = 0;
		System.out.println("Would you like to change the number of rounds from 5? Enter \"y\" or \"n\"");
		if (scanner.next().equalsIgnoreCase("y")) {
			System.out.println("OK.. enter the number of rounds you'd like to play now: ");
			rounds = scanner.nextInt();
		}
		for (int i = 1; i <= rounds; i++) {
			System.out.println("Round " + i + " Please enter \"Rock\",\"Paper\" or \"Scissors");
			Random random = new Random();
			int intComputerGuess = random.nextInt(3);
			String stringComputerAnswer = answers[intComputerGuess];
			String userInput = scanner.next();
			while (!isValidAnswer(userInput, answers)) {
				System.out.println("Please enter \"Rock\",\"Paper\",\"Scissors\"");
				userInput = scanner.next();
			}
			try {
				// Check user input
				System.out.println("You picked " + userInput);
				if (isValidAnswer(userInput, answers)) {
					System.out.print("Computer picks ");
					for (int j = 0; j < 3; j++) {
						System.out.print(".");
						Thread.sleep(700);
					}
					System.out.print(" "+stringComputerAnswer+" ");

					if (isPlayerWin(userInput, stringComputerAnswer)) {
						playerScore += 1;
						System.out.println("Player wins your score is " + playerScore);
					} else if (isComputerWin(userInput, stringComputerAnswer)) {
						computerScore += 1;
						System.out.println("Compuer wins their score is " + computerScore);
					} else {
						drawScore += 1;
						System.out.println("Draw .... draw score is " + drawScore);
					}
				}
			} catch (Exception e) {
				System.out.println("Your choice wasn't valid. Please enter \"Rock\",\"Paper\" or \"Scissors ");
			}
		}
		printStats(playerScore,computerScore,drawScore,rounds);
	}

	public static boolean isPlayerWin(String playerGuess, String computerGuess) {
		if (playerGuess.equalsIgnoreCase("Rock") && computerGuess.equalsIgnoreCase("Scissors")) {
			return true;
		} else if (playerGuess.equalsIgnoreCase("Paper") && computerGuess.equalsIgnoreCase("Rock")) {
			return true;
		} else if (playerGuess.equalsIgnoreCase("Scissors") && computerGuess.equalsIgnoreCase("Paper")) {
			return true;
		} else
			return false;
	}

	public static boolean isComputerWin(String playerGuess, String computerGuess) {
		if (playerGuess.equalsIgnoreCase("Rock") && computerGuess.equalsIgnoreCase("Paper")) {
			return true;
		} else if (playerGuess.equalsIgnoreCase("Paper") && computerGuess.equalsIgnoreCase("Scissors")) {
			return true;
		} else if (playerGuess.equalsIgnoreCase("Scissors") && computerGuess.equalsIgnoreCase("Rock")) {
			return true;
		} else
			return false;
	}

	public static boolean isValidAnswer(String userAnswer, String[] answers) {
		for (String string : answers) {
			if (string.equalsIgnoreCase(userAnswer)) {
				return true;
			}
		}
		System.out.println("You picked wrong with " + userAnswer + " try again ");
		return false;
	}

	public static void printStats(int playerScore, int computerScore, int drawScore, int rounds) {
		// Print statistics out
		System.out.println("------------------------Statistics---------------------------\n");
		System.out.println("Player percentage: " + (double) playerScore / rounds * 100 + "%");
		System.out.println("Computer percentage: " + (double) computerScore / rounds * 100 + "%");
		System.out.println("Draw percentage: " + (double) drawScore / rounds * 100 + "%");
	}
}
