package week2;
import java.util.Locale;
import java.util.Scanner;
public class VotingSystem {

	public static void main(String[] args) {
		// Ask for user's vote
		System.out.println("Voting...\nEnter \'con\' for Conservative and \'lab\' for Labour");
		
		// Instantiate the scanner
		Scanner scanner = new Scanner(System.in);
		String vote= scanner.next().toLowerCase(Locale.ROOT).trim();
		
		// Logic to confirm vote with user
		if (vote.equals("con")) {
			System.out.println("Voting registered for Conservative");
		} 
		else if (vote.equals("lab")) {
			System.out.println("Voting registered for Labour");
		}
		else  {
			System.out.println("Sorry voting party "+vote+" unrecognised.");
		}
		// Close the scanner
		scanner.close();
	}
}
