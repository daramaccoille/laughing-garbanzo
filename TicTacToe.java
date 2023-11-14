/**
 * 
 */
package Revision;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * @author dmaccoille820
 * @version 06/11/2023
 */
public class TicTacToe {

	/**
	 * @param args for main
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// some variables
		
		int[] squaresIntTaken = new int[9];
		String[][] squaresFilledWithXO = new String[][] { { " ", " ", " " }, { " ", " ", " " }, { " ", " ", " " } };
		String computerCharacter="";
		Scanner scanner = new Scanner(System.in);
		
		// Print header
		printHeader(squaresFilledWithXO);

		// Sort who's "X" or "O"
		String playerCharacter = pickCharacter(scanner);
		if (playerCharacter.equalsIgnoreCase("X")) {
			computerCharacter="O";
		}
		else {
			computerCharacter="X";
		}
	
		// Flip a coin to see who goes first
		boolean goesFirst = coinFlipWin(scanner);
		// Play a game 
		for (int i = 0; i < 9; i++) {
			
		
			if (!goesFirst) {
				printBoard(squaresFilledWithXO);
				computerGuess(squaresIntTaken, squaresFilledWithXO,computerCharacter);
				collectUserGuess(scanner, squaresIntTaken, squaresFilledWithXO, playerCharacter);
				checkWinningLine(squaresFilledWithXO);
				
			} else {// Collect user guess from console
				printBoard(squaresFilledWithXO);
				System.out.println("Enter a number 1-9 for "+playerCharacter);
				collectUserGuess(scanner, squaresIntTaken, squaresFilledWithXO, playerCharacter);
				computerGuess( squaresIntTaken, squaresFilledWithXO,computerCharacter);
				// Check for winner
				checkWinningLine(squaresFilledWithXO);
			}
		}
	}

	public static String[][] computerGuess( int[] squaresIntTaken, String[][] board, String computerCharacter) 
			throws InterruptedException {
		boolean validSquare=false;
		// Add computer guess to board
		Random random = new Random();
		int guess=0;
		while (!validSquare) 
		{
			// Check the square is available
			for (int i = 0; i < squaresIntTaken.length; i++) {
				if (squaresIntTaken[i]>0) {
					System.out.print(squaresIntTaken[i]+" is taken\n");
				}
			}
			
			
			System.out.println();
			guess = random.nextInt(8) + 1;
			for (int i : squaresIntTaken) {
				if (i==guess) {
				}
				else {
					validSquare=true;
					squaresIntTaken[guess]=guess;
				}
			}
		}
		// Add computer guess to the integer array of spaces taken
		squaresIntTaken[guess] = guess-1;
		// Print the computer guess to console
		System.out.println("Computer picks space ");
		for (int j = 0; j < 3; j++) {
			System.out.print(".");
			Thread.sleep(700);
		}
		System.out.println(guess);
		
			// Add the computer guess to the board
			switch (guess) {
			case 1:board[0][0] = computerCharacter;break;
			case 2:board[0][1] = computerCharacter;break;
			case 3:board[0][2] = computerCharacter;break;
			case 4:board[1][0] = computerCharacter;break;
			case 5:board[1][1] = computerCharacter;break;
			case 6:board[1][2] = computerCharacter;break;
			case 7:board[2][0] = computerCharacter;break;
			case 8:board[2][1] = computerCharacter;break;
			case 9:board[2][2] = computerCharacter;break;
			default:System.out.println("Invalid guess");
			}
			printBoard(board);
			return board;
	}
	
	
	public static String pickCharacters(Scanner scanner) {
		
		if (scanner.next().equalsIgnoreCase("X")) {
			return "X";
		} else {
			return"O";
		}
	}
	/**
	 * Print header
	 */
	public static void printHeader(String[][] squaresFilledWithXO) {
		System.out.println("Welcome to tic -tac - toe\n");
		System.out.println("The board looks like this: \n");
		printBoard(squaresFilledWithXO);
		System.out.println("\nAnd the corresponding numbers for guesses: \n");
		System.out.println(" 1 | 2 | 3 ");
		System.out.println("----------- ");
		System.out.println(" 4 | 5 | 6 ");
		System.out.println("----------- ");
		System.out.println(" 7 | 8 | 9 \n");
	}

	/**
	 * Print board
	 */
	public static void printBoard(String[][] squaresFilledWithXO) {

		System.out.println(" " + squaresFilledWithXO[0][0] + " | " + squaresFilledWithXO[0][1] + " |"
				+ squaresFilledWithXO[0][2] + "");
		System.out.println("----------- ");
		System.out.println(" " + squaresFilledWithXO[1][0] + " | " + squaresFilledWithXO[1][1] + " |"
				+ squaresFilledWithXO[1][2] + "");
		System.out.println("----------- ");
		System.out.println(" " + squaresFilledWithXO[2][0] + " | " + squaresFilledWithXO[2][1] + " |"
				+ squaresFilledWithXO[2][2] + "");
	}

	public static String pickCharacter(Scanner scanner) {

		boolean validChoice = false;
		while (!validChoice) {
			System.out.println("Please pick your character \"X\" or\"O\" :");
			String choice = scanner.next();
			if (choice.equalsIgnoreCase("X") || choice.equalsIgnoreCase("O")) {
				validChoice = true;
				System.out.println("Ok you picked " + choice);
				return choice;
			}
		}
		return "Z";
	}

	/**
	 * 
	 * @param scanner
	 * @return
	 */
	public static boolean coinFlipWin(Scanner scanner) {
		// Flip a coin to see who goes first
		Random random = new Random();
		int coin = random.nextInt(2);
		System.out.println("Please choose \"Heads\" or \"Tails\"");
		int playerToss = scanner.next().equalsIgnoreCase("Heads") ? 0 : 1;
		String message;
		if (playerToss == coin) {

			message = "You win the toss and go first";
			System.out.println(message);
			return true;
		} else {
			message = "You lost and go second";
			System.out.println(message);
			return false;
		}
	}

	public static String[][] collectUserGuess(Scanner scanner, int[] squaresIntTaken, String[][] board,
			String userCharacter) {
		boolean validGuess=false;
		int userGuess;
		String numsTaken="";
		while(!validGuess) {
			// Check which squares are taken
			if (numsTaken.length()>0) {System.out.println("Please pick an empty square except " + numsTaken);}
			else {System.out.println("Please pick a square 1 to 9");}
			
			userGuess = scanner.nextInt();
			// Check user guess
			if (userGuess>0 && userGuess<10) {
				for (int num : squaresIntTaken) {
					if (userGuess==num) {
						System.out.println("Guess "+userGuess +" is already taken");
					}
					else {
						validGuess=true;
						numsTaken+=num+" ";
						squaresIntTaken[userGuess-1] = userGuess;
						while (squaresIntTaken[userGuess] == userGuess) {
							
								System.out.println("Please enter a square that's not " + userGuess + Arrays.deepToString(board));
							} 
						
								squaresIntTaken[userGuess-1] = userGuess;
								switch (userGuess) {
								case 1:board[0][0] = userCharacter;break;
								case 2:board[0][1] = userCharacter;break;
								case 3:board[0][2] = userCharacter;break;
								case 4:board[1][0] = userCharacter;break;
								case 5:board[1][1] = userCharacter;break;
								case 6:board[1][2] = userCharacter;break;
								case 7:board[2][0] = userCharacter;break;
								case 8:board[2][1] = userCharacter;break;
								case 9:board[2][2] = userCharacter;break;
								default:System.out.println("Invalid guess");
								}
							}
							
						}
						return board;
					}
				}
			
		return board;
	}

public static boolean checkWinningLine(String[][] board) {
	boolean hasBoardSpace=false;
	while(!hasBoardSpace) {
	for (int i = 0; i < board.length; i++) {
		for (int j = 0; j < board[i].length; j++) {
			if (!(board[i][j].equalsIgnoreCase("X")||board[i][j].equalsIgnoreCase("O"))) {
				hasBoardSpace=true;
				return hasBoardSpace;
			}
			else {
				hasBoardSpace=false;
				return hasBoardSpace;
			}
		}
	}
}
if ((board[0][0].equals("X")&& board[0][1].equals("X")&&board[0][2].equals("X"))||
		(board[1][0].equals("X")&& board[1][1].equals("X")&&board[1][2].equals("X"))||
		(board[2][0].equals("X")&& board[2][1].equals("X")&&board[2][2].equals("X"))||
		(board[0][0].equals("X")&& board[1][0].equals("X")&&board[2][0].equals("X"))||
		(board[0][1].equals("X")&& board[1][1].equals("X")&&board[2][1].equals("X"))||
		(board[0][2].equals("X")&& board[1][2].equals("X")&&board[2][2].equals("X"))||
		(board[0][0].equals("X")&& board[1][1].equals("X")&&board[2][2].equals("X"))||
		(board[0][2].equals("X")&& board[1][1].equals("X")&&board[2][0].equals("X"))
		) 
{System.out.println("X wins");return false;}

else if ((board[0][0].equals("O")&& board[0][1].equals("O")&&board[0][2].equals("O"))||
		(board[1][0].equals("O")&& board[1][1].equals("O")&&board[1][2].equals("O"))||
		(board[2][0].equals("O")&& board[2][1].equals("O")&&board[2][2].equals("O"))||
		(board[0][0].equals("O")&& board[1][0].equals("O")&&board[2][0].equals("O"))||
		(board[0][1].equals("O")&& board[1][1].equals("O")&&board[2][1].equals("O"))||
		(board[0][2].equals("O")&& board[1][2].equals("O")&&board[2][2].equals("O"))||
		(board[0][0].equals("O")&& board[1][1].equals("O")&&board[2][2].equals("O"))||
		(board[0][2].equals("O")&& board[1][1].equals("O")&&board[2][0].equals("O"))
		)
{System.out.println("O wins");return false;}
return hasBoardSpace;

}

public static void printGameStats() {
	System.out.printf("Player win");
	System.out.printf("Computer win");
	System.out.printf("Draw");
}
}
