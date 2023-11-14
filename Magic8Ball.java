/**
 * 
 */
package week3;
import java.util.Random;
import java.util.Scanner;
/**
 * @author dmaccoille820
 * @version 30/09/2023
 */
public class Magic8Ball {

	/**
	 * @param args for main method
	 */
	public static void main(String[] args) {
		
		// Ask the user to enter a question
		Scanner scanner = new Scanner (System.in);
		System.out.println("Please enter your question and the 8 ball will give you an answer: ");
		
		scanner.nextLine();
		// Get a random number between 0 and 7
		Random rand = new Random();
		int answer = rand.nextInt(8);
		
		// Switch case to print the answer
		switch(answer) {
		case 0:System.out.println("As I see it, yes."); break;
		case 1:System.out.println("Ask again later."); break;
		case 2:System.out.println("Better not tell you now."); break;
		case 3:System.out.println("Cannot predict now."); break;
		case 4:System.out.println("Concentrate and ask again."); break;
		case 5:System.out.println("Don't count on it."); break;
		case 6:System.out.println("It is certain."); break;
		case 7:System.out.println("It is decidedly so."); break;
		default:System.out.println("Eight ball is broken");
		}
			scanner.close();
	}
}
