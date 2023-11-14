/**
 * 
 */
package week6_reading;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Dara Mac Coille
 * @version Nov 3, 2023
 */
public class Cipher {

	/**
	 * @param args for main method
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter text to be ciphered: ");
		String d = new String(scanner.next());
		
		 char[] chars =d.toCharArray();
		 char[] changeMe= new char[d.length()];
		 for (int i = 0; i < changeMe.length; i++) {
			changeMe[i]=(char) (chars[i]+3);
		}
		 
			System.out.println(String.valueOf(chars)); 
			System.out.println(String.valueOf(changeMe).toUpperCase());
			scanner.close();
	}

}
