/**
 * 
 */
package RockPaperScissors;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Dara Mac Coille daramaccoille@gmail.com
 * @version 01/11/2023
 */
public class RockPaperScissors {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// variables
		int rounds = 5;
		int playerScore = 0;
		int computerScore = 0;
		int drawScore = 0;
		String changeRounds;
		String[] guesses = new String[] { "rock", "paper", "scissors" };
		Scanner scanner = new Scanner(System.in);
		
		// Print header and collect change rounds answer
		System.out.println("Welcome, would you like to change rounds from " + rounds + " 'Y/N'?");
		changeRounds = scanner.next();

		// collect new number of rounds
		if (changeRounds.equalsIgnoreCase("Y")) {
			System.out.println("OK enter the number of rounds to play now: ");
			rounds = scanner.nextInt();
			System.out.println("OK let's play "+rounds+" rounds");
			scanner.nextLine();
		}
		else {
			
			scanner.nextLine();
		}
		
		// Iterate over the number of rounds
		for (int i = 1; i <= rounds; i++) {

			// Guesses
			System.out.println("Round " + i + " Please write \"Rock\",\"Paper\", "
					+ "or \"Scissors\":");
			
			// Random guess for computer
			Random random = new Random();
			int computerIntGuess = random.nextInt(3);
			String computerStringGuess = guesses[computerIntGuess];
			
			// Collect user guess
			String playerUnvalidatedGuess = scanner.nextLine();
			// Validate user input
			boolean validAnswer = validatePlayerGuess(playerUnvalidatedGuess.toLowerCase(),guesses);
			 while (validAnswer==false)
			{
				 System.out.println("Sorry "+playerUnvalidatedGuess+" wasn't right. Please write \"Rock\",\"Paper\", or \"Scissors\":");
			playerUnvalidatedGuess = scanner.nextLine();
			validAnswer=validatePlayerGuess(playerUnvalidatedGuess.toLowerCase(),guesses);
			}
				// Calculate if player has won
				if (playerUnvalidatedGuess.equalsIgnoreCase("rock") && computerStringGuess.equals("scissors")
						|| playerUnvalidatedGuess.equalsIgnoreCase("paper") && computerStringGuess.equals("rock")
						|| playerUnvalidatedGuess.equalsIgnoreCase("scissors") && computerStringGuess.equals("paper")) {
					playerScore += 1;
					System.out.println("Computer chose " + computerStringGuess + " and you" + " chose "
							+ playerUnvalidatedGuess + " so you have gained a point!");
					printScore(computerScore, playerScore, drawScore);
				}

				// Calculate if computer has won
				else if (playerUnvalidatedGuess.equalsIgnoreCase("scissors") && computerStringGuess.equals("rock")
						|| playerUnvalidatedGuess.equalsIgnoreCase("rock") && computerStringGuess.equals("paper")
						|| playerUnvalidatedGuess.equalsIgnoreCase("paper") && computerStringGuess.equals("scissors")) {
					computerScore += 1;
					System.out.println("Computer chose " + computerStringGuess + " and you" + " chose "
							+ playerUnvalidatedGuess + " so computer has gained a point!");
					printScore(computerScore, playerScore, drawScore);
				}
				// Calculate if it's a draw
				else {
					drawScore += 1;
					System.out.println("Computer chose " + computerStringGuess + " and you" + " chose "
							+ playerUnvalidatedGuess + " so no one gets a point!");
					printScore(computerScore, playerScore, drawScore);
				}
			
		}
		//scanner.close();
		printGameStats(computerScore, playerScore, drawScore,rounds);
	} 

	public static void printScore(int computerScore, int playerScore, int drawScore) {
		System.out.println("--------------------------------------------------------------");
		System.out.println(
				"The scores are \tPlayer: " + playerScore + "\tComputer: " + computerScore + "\tDraws: " + drawScore);
		System.out.println("--------------------------------------------------------------");
	}

	/**
	 * 
	 * @param playerUnvalidatedGuess is the String guess collected from the scanner
	 * @param guesses                is the String array that holds rock, paper and
	 *                               scissors
	 * @return a boolean if the scanner string is in the guesses array
	 */
	public static boolean validatePlayerGuess(String playerUnvalidatedGuess, String[] guesses) {
		boolean validGuess;
		validGuess=Arrays.asList(guesses).contains(playerUnvalidatedGuess)?true:false;
		return validGuess;
	}
	public static void printGameStats(int compScore, int playScore, int draws, int rounds) {
		double playerPercentage=((double)playScore/(double)rounds)*100;
		double computerPercentage=((double)compScore/(double)rounds)*100;
		double drawPercentage=((double)draws/(double)rounds)*100;
		
		System.out.println("----------------------------------------------------------");
		System.out.println("--------Thanks for playing, here's the stats--------------");
		System.out.println();
		System.out.printf("Player percentage win :\t\t %.2f\n",playerPercentage);
		System.out.printf("Computer percentage win :\t %.2f\n",computerPercentage);
		System.out.printf("Draw percentage win :\t\t %.2f\n",drawPercentage);
	}

}
