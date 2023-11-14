/**
 * 
 */
package week6_reading;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * @author dmaccoille820
 * @version 11/03/2023
 * WeekNumberToString method will change a number for example 1
 * to a three character string for example "Mon"
 */
public class WeekNumberToString {

	/**
	 * @param args for main method
	 * main method is where the fun starts
	 */
	public static void main(String[] args) {
		
		// Create scanner for use throughout program
		Scanner scanner = new Scanner(System.in);
		// Get use input for an integer
		printHeader();
		//  Perform some validation on the user input
		int day =validateUserInput(scanner);
		// TODO Compare the integer to an array of strings
		boolean isValid;
		isValid=(day>0&&day<=7)?true:false;
		// TODO Print a line confirming the user input and the corresponding day
		String[] daysOfWeek = new String[] {"Mon","Tue","Wed","Thu","Fri","Sat","Sun"};
		if (isValid) {
			System.out.println("You entered "+day+" and that is the day "+daysOfWeek[day-1]);
		}
		else {
			System.out.println("invalid input " +day);
		}
		// TODO check out date and time library
		Date now = new Date();
		 Calendar calendar = Calendar.getInstance();
		
		 calendar.setTime(now);
		 
		 System.out.println(calendar.getTime());
		 SimpleDateFormat sdf = new SimpleDateFormat("EE");
		 
		 System.out.println(sdf.format(calendar.getTime()));
		// TODO check out debugging

	}
	public static void printHeader() {
		// Print header
		System.out.println("Please enter an integer from 1 to 7 inclusive: ");
	}
	public static int validateUserInput(Scanner scanner) {
		String userInput = scanner.nextLine();
		int userInt=-1;
		try {
			userInt = Integer.parseInt(userInput);
		} catch (Exception e) {
			System.out.println("Error with input "+userInput);
		}
		return userInt;
	}

}
