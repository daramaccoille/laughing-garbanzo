/**
 * 
 */
package week2;

//import org.apache.commons.lang3.StringUtils;
//import java.io.*;
import java.util.Scanner;
/**
 * @author dmaccoille820
 *
 */
public class ifs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter your name: ");
		String name = scanner.nextLine();
		System.out.println("Please enter your age: ");
		String _age = scanner.nextLine();
		int age = Integer.parseInt(_age);
		System.out.printf("Hi %s %n your age is %d",name,age);
		scanner.close();
		System.out.println();
	}

}
