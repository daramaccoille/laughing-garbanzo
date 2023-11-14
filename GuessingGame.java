/**
 * 
 */
package week4Loops;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;

/**
 * @author dmaccoille820
 *
 */
public class GuessingGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		Random rand = new Random();
		int answer = rand.nextInt(10);
		answer++;
		int guess;

		try {
			do {
				System.out.println("Make a guess between 1-10 " + answer);
				guess = scanner.nextInt();
				if (answer == guess) {
					System.out.println("Congrats it was " + answer);
				}
			} while (answer != guess);
			scanner.close();
		} catch (InputMismatchException ex) {
			guess = scanner.nextInt();
			System.out.println("Make a proper guess between 1-10 " + answer);
		}

	}
}
