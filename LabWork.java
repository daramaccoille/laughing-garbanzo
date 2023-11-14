/**
 * 
 */
package Methods;

import java.util.Scanner;

/**
 * @author dmaccoille820
 * @version 10/10/23
 */
public class LabWork {

	/**
	 * @param args for main
	 */
	public static void main(String[] args) {
		
		EvenOrOdd();
		convertFromUpperToLower('F');
		isMultiple(5,10);
	}
/**
 * EvenOrOdd attempts to determine if a given integer is divisible by 2
 */
	private static void EvenOrOdd() {
		System.out.println("Enter a number to find if it's even or odd");
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		if (num%2==0) {
			System.out.println("The number "+num+" is even");
		}
		else {System.out.println("The number "+num+" is odd");}
		scanner.close();
	}
	
	/**
	 * convertFromUpperToLower attempts to change an upper case letter to lower case
	 * @param letter
	 */
	private static void convertFromUpperToLower(char letter) {
		if (Character.isLowerCase(letter)) {
			System.out.println("The character "+letter+" is lower case already");
		}
		else {
			System.out.println(Character.toLowerCase(letter));
		}
	}
	public static void isMultiple(int num1, int num2) {
		if (num1/num2==1) {
			System.out.println("The numbers "+num1+" "+num2+" are the same.");
		}
		else if (num2%num1==0) {
			System.out.println("The number "+num2+" is divisible by "+num1);
		}
		else if (num2%num1!=0) {
			System.out.println("The number "+num2+" is not divisible by "+num1);
		}
	}

}
