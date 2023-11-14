/**
 * 
 */
package week2;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * @author dmaccoille820
 *
 */
public class OperatorExample {

	public static void main(String[] args) {
		//operators example
		int number1,number2, answer;
		number1=16;
		number2=10;
		double number3=15.23;
		//String operator = "add";
		//do calculation
		answer = number1 - number2;
		answer = number1%number2;
		String formatted = String.format("number 3: %s",answer);
		System.out.println(formatted + number3);
		if (number1!=number2) {
			System.out.println("1 is less than 2");
		}
ArrayList<Integer> arrL = new ArrayList<Integer>();
arrL.add(1);
arrL.add(2);
Scanner s = new Scanner(System.in);
String num = s.nextLine();
s.close();
arrL.add(Integer.parseInt(num));
arrL.sort(null);
System.out.println(arrL);
int value = 5/3;
System.out.println(value);
	}

}
