/**
 * 
 */
package Revision;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author dmaccoille820
 * @version 30/10/2023
 */
public class ConvertStringToASCII {

	/**
	 * main method will collect user input and 
	 * print the return value from the convert to Ascii method
	 * @param args for main method
	 */
	public static void main(String[] args) {
		// Part 1 String to ASCII
		System.out.println("Please enter your name to be converted to ASCII:  " );
		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();
		System.out.println(ASCIIvalueForEachCharacter(name));
		
		// Part 2 int[] to String
		//int[] inputAscii = new int[] {68, 97, 114, 97, 32, 77, 97, 99, 32, 67, 111, 105, 108, 108, 101};
		
		// Get String
		System.out.println("Hello \u001b[1;31mred\u001b[0m world!" );
		String scannerInputAscii = scanner.nextLine();
		
		char[] chars = intArrayToChars(scannerInputAscii);
		System.out.print(chars);
		
		scanner.close();
	}
	/**
	 * intArrayToChars will take a scanner Input of comma
	 * and space separated values for converting to a char array
	 * @param scannerInputAscii
	 * @return a char array for printing
	 */
	private static char[] intArrayToChars(String scannerInputAscii) {
		// Makes a string array of the last input
		String[] stringAsciis = scannerInputAscii.split(", ");
		
		// Make int array from string array
		int[] asciis = new int[stringAsciis.length];
		for (int i = 0; i < asciis.length; i++) {
			asciis[i]=Integer.valueOf(stringAsciis[i]);
		}
		
		// Make char array from int Array
		char[] chars = new char[asciis.length];
		for (int i=0;i<asciis.length;i++) {
			chars[i]= (char)asciis[i];
		}
		return chars;
	}	
	/**
	 * 
	 * @param inputName as user input from scanner in main method
	 * @return a String representing the integer array values
	 * of each character in the parameter
	 */
	public static String ASCIIvalueForEachCharacter(String inputName){

		// for loop to iterate through the string
		int[] ASCIIvalues= new int[inputName.length()];
		for (int i = 0; i < inputName.length(); i++) {
			// convert each character to its ASCII code
			ASCIIvalues[i]=(int)inputName.charAt(i);
			
		}
		String convertedValues=Arrays.toString(ASCIIvalues);
		return convertedValues;
		}
	/**
	 * 
	 * @param inputArray takes an array of integers for converting
	 * @return outputString for printing in main method
	 */
	public static String charArraytoString(int[] inputArray) {
		char[] outputChars=new char[inputArray.length];
		for (int i = 0; i < inputArray.length; i++) {
			char c = (char)inputArray[i];
			outputChars[i]=c;
		}
		// String method valuieOf will take a char array and convert to String
		String outputString= String.valueOf(outputChars);
		return outputString;
	}
}
