package week6_Arrays;

import java.util.Random;
import java.util.Scanner;

/**
 * Battleships on the Console
 * 
 * @author Dara Mac Coille
 * @version 20/10/23
 */
public class Battleships {

	/**
	 * main method: create ships, boards user input and random computer guesses to
	 * play the game of battleships
	 * 
	 * @param args for main
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		// Create 2 sets of ships. Four ships of 2,
		// Three ship of 3 two ships of four, 1 ship of 5
		Ship[] computerShips = new Ship[] { new Ship(2, isVertical(), false, "Tug1", false),
				new Ship(2, isVertical(), false, "Tug2", false), new Ship(2, isVertical(), false, "Tug3", false),
				new Ship(2, isVertical(), false, "Tug4", false), new Ship(3, isVertical(), false, "Liner1", false),
				new Ship(3, isVertical(), false, "Liner2", false), new Ship(3, isVertical(), false, "Liner3", false),
				new Ship(4, isVertical(), false, "Frigate1", false),
				new Ship(4, isVertical(), false, "Frigate2", false),
				new Ship(5, isVertical(), false, "Destroyer", false) };
		Ship[] playerShips = new Ship[] { new Ship(2, isVertical(), false, "Tug1", false),
				new Ship(2, isVertical(), false, "Tug2", false), new Ship(2, isVertical(), false, "Tug3", false),
				new Ship(2, isVertical(), false, "Tug4", false), new Ship(3, isVertical(), false, "Liner1", false),
				new Ship(3, isVertical(), false, "Liner2", false), new Ship(3, isVertical(), false, "Liner3", false),
				new Ship(4, isVertical(), false, "Frigate1", false),
				new Ship(4, isVertical(), false, "Frigate2", false),
				new Ship(5, isVertical(), false, "Destroyer", false) };

		// Initialize 3 game board of 10 x 10
		String[][] playerBoard = new String[10][10];
		String[][] computerBoard = new String[10][10];
		// 1 for the player to see their misses and hits on the computer board
		String[][] computerPlayerBoard = new String[10][10];
		// Add tilde to each row and column of computerPlayerBoard
		for (int i = 0; i < computerPlayerBoard.length; i++) {
			for (int j = 0; j < computerPlayerBoard.length; j++) {
				computerPlayerBoard[i][j] = "~";
			}
		}
		// wrapped scores in reference type. position 0 for computerScore, position1 for
		// player score
		int[] scores = new int[] { 0, 0 };

		// Opening header showing how co-ordinates work and asking if player wants to
		// cheat
		System.out.println("--------------------------------------------------------------\n");
		System.out.println("\u001B[34m"+"🎯  Welcome to battle ships, co-ordinates are like 'A2' or 'I9' 🎯 \n");
		PrintStartBoard();
		System.out.println("Now let's see our board filled with ships at random positions"
				+ " holding values\n D-Destroyer, F-Frigate, L-Liner T-Tug, ~ sea, X-hit and O-miss");
		// Print the player board filled with ship initial random positions
		PrintRoundBoard(FilledRandomBoard(InitialRandomBoard(playerBoard), playerShips));
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n\nWould you like to cheat and see where the computer's ships are Y/N?");
		String response = scanner.nextLine();
		if (response.equalsIgnoreCase("Y")) {

			System.out.println("--------------------------------------------------------------");
			System.out.println("Ok... here is where the computer has placed their ships!");
			// Print the computer board filled with ship initial random positions
			PrintRoundBoard(FilledRandomBoard(InitialRandomBoard(computerBoard), computerShips));

		} else {
			computerBoard = FilledRandomBoard(InitialRandomBoard(computerBoard), computerShips);
			System.out.println("--------------------------------------------------------------");
		}
		System.out
				.println("Ok let's get started. Score is:\t" + scores[1] + " : Player\t" + scores[0] + " : Computer");
		while (scores[0] < 20 && scores[1] < 20) {

			System.out.println("--------------------------------------------------------------");
			System.out.println("Here is our board");

			// Print the player board filled with ship initial random positions
			PrintRoundBoard(playerBoard);

			// Computer makes a random guess
			guessByComputer(playerBoard, scores);
			System.out.println("\nScore is:\t" + scores[1] + " : Player\t" + scores[0] + " : Computer");

			// Show computer guess on player's board
			PrintRoundBoard(playerBoard);

			// Ask for players guess
			System.out.println("Computer Board");
			System.out.println("--------------------------------------------------------------\n");

			// Show computerPlayerBoard
			PrintComputerRoundBoard(computerPlayerBoard);
			System.out.println("Ok, our turn. Enter co-ordinated like A1 (A-J,1-10):");
			
			//Collect user's guess in A1 notation
			String coords = scanner.next();

			// Send the coord of player guess, along with boards and scores for processing
			guessByPlayer(computerBoard, computerPlayerBoard, coords, scores);

			// Show updated computerPlayerBoard
			PrintComputerRoundBoard(computerPlayerBoard);
			System.out.println("\nScore is:\n" + scores[1] + " : Player\n" + scores[0] + " : Computer\n");

		}
		System.out.println("We have a a winner");
		scanner.close();
	}

	/**
	 * Print the Start board with just sea and axis labels
	 */
	public static void PrintStartBoard() {
		System.out.println("--------------------------------------------------------------");
		System.out.println("Here is what a board looks like at the start\n");
		System.out.println("   12345678910");
		for (char i = 'A'; i <= 'J'; i++) {
			System.out.print("\n" + i + "  ");
			for (int j = 0; j <= 10; j++)
				System.out.print("~"); // End of inner loop
		} // End of outer loop
		System.out.println("\n\n--------------------------------------------------------------");
	}

	/**
	 * PrintRoundBoard takes in a board and prints the axis and values of the
	 * 
	 * @param board String[][] holding values D-Destroyer, F-Frigate, L-Liner T-Tug,
	 *              ~ sea, X-hit and O-miss
	 */
	public static void PrintRoundBoard(String[][] board) {
		System.out.println("--------------------------------------------------------------\n");

		System.out.println("   12345678910");
		for (char i = 'A'; i <= 'J'; i++) {
			System.out.print(i + "  ");

			for (int col = 0; col < 10; col++) {
				System.out.print(board[i - 65][col]);
			} // End of print cells loop
			System.out.println();
		} // End of row count loop
		System.out.println("\n--------------------------------------------------------------");
	}

	public static void PrintComputerRoundBoard(String[][] board) {
		System.out.println("   12345678910");
		for (char i = 'A'; i <= 'J'; i++) {
			System.out.print(i + "  ");
			for (int col = 0; col < 10; col++) {
				if (board[i - 65][col].equals("D") || board[i - 65][col].equals("F") || board[i - 65][col].equals("L")
						|| board[i - 65][col].equals("T")) {
					System.out.print("~");
				} else {
					System.out.print(board[i - 65][col]);
				}
			} // End of print cells loop
			System.out.println();
		} // End of row count loop
	}

	/**
	 * Ship class has fields of: length, isVertical, isDestroyed, isPositioned, name
	 */
	public static class Ship {
		int length;
		boolean isVertical;
		boolean isDestroyed;
		boolean isPositioned;
		String name;

		Ship(int l, boolean v, boolean d, String n, boolean p) {
			this.length = l;
			this.isVertical = v;
			this.isDestroyed = d;
			this.name = n;
			this.isPositioned = p;
		}
	}

	public static String[][] InitialRandomBoard(String[][] board) {

		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				board[row][col] = "~";
			}
		}
		return board;
	}

	public static String[][] FilledRandomBoard(String[][] board, Ship[] liveShips) {
		placeDestroyer(board, liveShips[9]);
		placeFrigate(board, liveShips[8]);
		placeFrigate(board, liveShips[7]);
		placeLiner(board, liveShips[6]);
		placeLiner(board, liveShips[5]);
		placeLiner(board, liveShips[4]);
		placeTug(board, liveShips[3]);
		placeTug(board, liveShips[2]);
		placeTug(board, liveShips[1]);
		placeTug(board, liveShips[0]);
		return board;
	}

	public static boolean isVertical() {
		Random rand = new Random();
		int vert = rand.nextInt(2);
		if (vert == 1) {
			return true;
		} else {
			return false;
		}
	}

	public static String[][] placeDestroyer(String[][] board, Ship Destroyer) {

		if (Destroyer.isVertical == true) {
			while (Destroyer.isPositioned == false) {
				Random randomCol = new Random();
				int randomC = randomCol.nextInt(9);
				Random randomRow = new Random();
				int randomR = randomRow.nextInt(4);
				if (board[randomR][randomC] == "~" && board[randomR + 1][randomC] == "~"
						&& board[randomR + 2][randomC] == "~" && board[randomR + 3][randomC] == "~"
						&& board[randomR + 4][randomC] == "~") {
					board[randomR][randomC] = "D";
					board[randomR + 1][randomC] = "D";
					board[randomR + 2][randomC] = "D";
					board[randomR + 3][randomC] = "D";
					board[randomR + 4][randomC] = "D";
					Destroyer.isPositioned = true;
				}
			}
		} else {
			while (Destroyer.isPositioned == false) {
				Random randomCol = new Random();
				int randomC = randomCol.nextInt(4);
				Random randomRow = new Random();
				int randomR = randomRow.nextInt(9);
				if (board[randomR][randomC] == "~" && board[randomR][randomC + 1] == "~"
						&& board[randomR][randomC + 2] == "~" && board[randomR][randomC + 3] == "~"
						&& board[randomR][randomC + 4] == "~") {
					board[randomR][randomC] = "D";
					board[randomR][randomC + 1] = "D";
					board[randomR][randomC + 2] = "D";
					board[randomR][randomC + 3] = "D";
					board[randomR][randomC + 4] = "D";
					Destroyer.isPositioned = true;
				}
			}
		}
		return board;
	}

	public static String[][] placeFrigate(String[][] board, Ship Frigate) {

		if (Frigate.isVertical == true) {
			while (Frigate.isPositioned == false) {
				Random randomCol = new Random();
				int randomC = randomCol.nextInt(9);
				Random randomRow = new Random();
				int randomR = randomRow.nextInt(5);
				if (board[randomR][randomC] == "~" && board[randomR + 1][randomC] == "~"
						&& board[randomR + 2][randomC] == "~" && board[randomR + 3][randomC] == "~") {
					board[randomR][randomC] = "F";
					board[randomR + 1][randomC] = "F";
					board[randomR + 2][randomC] = "F";
					board[randomR + 3][randomC] = "F";

					Frigate.isPositioned = true;
				}
			}
		} else {
			while (Frigate.isPositioned == false) {
				Random randomCol = new Random();
				int randomC = randomCol.nextInt(4);
				Random randomRow = new Random();
				int randomR = randomRow.nextInt(9);
				if (board[randomR][randomC] == "~" && board[randomR][randomC + 1] == "~"
						&& board[randomR][randomC + 2] == "~" && board[randomR][randomC + 3] == "~") {
					board[randomR][randomC] = "F";
					board[randomR][randomC + 1] = "F";
					board[randomR][randomC + 2] = "F";
					board[randomR][randomC + 3] = "F";
					Frigate.isPositioned = true;
				}
			}
		}
		return board;
	}

	public static String[][] placeLiner(String[][] board, Ship Liner) {

		if (Liner.isVertical == true) {
			while (Liner.isPositioned == false) {
				Random randomCol = new Random();
				int randomC = randomCol.nextInt(9);
				Random randomRow = new Random();
				int randomR = randomRow.nextInt(6);
				if (board[randomR][randomC] == "~" && board[randomR + 1][randomC] == "~"
						&& board[randomR + 2][randomC] == "~") {
					board[randomR][randomC] = "L";
					board[randomR + 1][randomC] = "L";
					board[randomR + 2][randomC] = "L";
					Liner.isPositioned = true;
				}
			}
		} else {
			while (Liner.isPositioned == false) {
				Random randomCol = new Random();
				int randomC = randomCol.nextInt(6);
				Random randomRow = new Random();
				int randomR = randomRow.nextInt(9);
				if (board[randomR][randomC] == "~" && board[randomR][randomC + 1] == "~"
						&& board[randomR][randomC + 2] == "~") {
					board[randomR][randomC] = "L";
					board[randomR][randomC + 1] = "L";
					board[randomR][randomC + 2] = "L";
					Liner.isPositioned = true;
				}
			}
		}
		return board;
	}

	public static String[][] placeTug(String[][] board, Ship Tug) {

		if (Tug.isVertical == true) {
			while (Tug.isPositioned == false) {
				Random randomCol = new Random();
				int randomC = randomCol.nextInt(10);
				Random randomRow = new Random();
				int randomR = randomRow.nextInt(7);
				if (board[randomR][randomC] == "~" && board[randomR + 1][randomC] == "~") {
					board[randomR][randomC] = "T";
					board[randomR + 1][randomC] = "T";
					Tug.isPositioned = true;
				}
			}
		} else {
			while (Tug.isPositioned == false) {
				Random randomCol = new Random();
				int randomC = randomCol.nextInt(7);
				Random randomRow = new Random();
				int randomR = randomRow.nextInt(10);
				if (board[randomR][randomC] == "~" && board[randomR][randomC + 1] == "~") {
					board[randomR][randomC] = "T";
					board[randomR][randomC + 1] = "T";
					Tug.isPositioned = true;
				}
			}
		}
		return board;
	}

	public static String[][] guessByComputer(String[][] playerBoard, int[] scores) throws InterruptedException {
		boolean guessComplete = false;
		System.out.print("Computer thinks.");
		for (int i = 0; i < 3; i++) {
			Thread.sleep(1000);
			System.out.print(".");
		}
		while (guessComplete == false) {
			Random random = new Random();
			int rowGuess = random.nextInt(10);
			int colGuess = random.nextInt(10);
			System.out.println("Guesses " + (char) (65 + rowGuess) + (colGuess + 1));
			Thread.sleep(500);
			if (playerBoard[rowGuess][colGuess] != "X" && playerBoard[rowGuess][colGuess] != "O") {
				if (playerBoard[rowGuess][colGuess].equals("D")) {
					System.out.print(" Destroyer Hit +5 for computer");
					playerBoard[rowGuess][colGuess] = "X";
					scores[0] += 5;
				} else if (playerBoard[rowGuess][colGuess].equals("F")) {
					System.out.print(" Frigate Hit +4 for computer");
					playerBoard[rowGuess][colGuess] = "X";
					scores[0] += 4;
				} else if (playerBoard[rowGuess][colGuess].equals("L")) {
					System.out.print(" Liner Hit +3 for computer");
					playerBoard[rowGuess][colGuess] = "X";
					scores[0] += 3;
				}

				else if (playerBoard[rowGuess][colGuess].equals("T")) {
					System.out.print(" Tug Hit +2 for computer");
					playerBoard[rowGuess][colGuess] = "X";
					scores[0] += 2;
				} else {
					System.out.print("Misses... phew");
					playerBoard[rowGuess][colGuess] = "O";
				}
			}
			guessComplete = true;
		}

		return playerBoard;
	}

	public static TwoArrays guessByPlayer(String[][] computerBoard, String[][] computerPlayerBoard, String coords, int[] scores)
			throws InterruptedException {
		boolean guessComplete = false;
		String sCol = coords.substring(1);
		int colGuess = Integer.parseInt(sCol) - 1;
		char cRow = coords.charAt(0);
		int rowGuess = cRow - 65;
		while (guessComplete == false) {

			System.out.println("We guess " + (char) (65 + rowGuess) + (colGuess + 1) + "...");
			Thread.sleep(500);
			if (computerBoard[rowGuess][colGuess] != "X" && computerBoard[rowGuess][colGuess] != "O") {
				if (computerBoard[rowGuess][colGuess].equals("D")) {
					System.out.println("Destroyer Hit");
					computerBoard[rowGuess][colGuess] = "X";
					computerPlayerBoard[rowGuess][colGuess] = "d";
					scores[1] += 5;
				} else if (computerBoard[rowGuess][colGuess].equals("F")) {
					System.out.println("Frigate Hit");
					computerBoard[rowGuess][colGuess] = "X";
					computerPlayerBoard[rowGuess][colGuess] = "f";
					scores[1] += 4;
				} else if (computerBoard[rowGuess][colGuess].equals("L")) {
					System.out.println("Liner Hit");
					computerBoard[rowGuess][colGuess] = "X";
					computerPlayerBoard[rowGuess][colGuess] = "l";
					scores[1] += 3;
				}

				else if (computerBoard[rowGuess][colGuess].equals("T")) {
					System.out.println("Tug Hit");
					computerBoard[rowGuess][colGuess] = "X";
					computerPlayerBoard[rowGuess][colGuess] = "t";
					scores[1] += 2;
				} else {
					System.out.println("Missed... unlucky\n");
					computerBoard[rowGuess][colGuess] = "O";
					computerPlayerBoard[rowGuess][colGuess] = "O";
				}
			}
			guessComplete = true;
		}
		TwoArrays arrays = arraysreturn(computerBoard, computerPlayerBoard);
		return arrays;
	}
	// Method to return both the computer Board and the computerPlayer Board
	public static TwoArrays arraysreturn(String[][] computerBoard,String[][] computerPlayerBoard) {
	    
	    return new TwoArrays(computerBoard,computerPlayerBoard);
	}

	// ANSI escape codes as constants to hold different colours for the console
	// needs eclipse version >2022
	// https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m ";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";
}
