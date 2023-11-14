package week6_Arrays;

import java.util.Scanner;

/**
 * 
 * @author Dara Mac Coille
 * @version 20/10/23
 *
 */

public class findMinArray {

	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		PrintChristmasTree( scanner.nextInt());
		scanner.close();
	}
	public static void PrintChristmasTree(int height) {
		String space = " ";
		String star = "*";
		for (int i = 1; i <= height; i+=2) {
			System.out.println(space.repeat((height-i)/2) +star.repeat(i));
		}
		
	}

}
