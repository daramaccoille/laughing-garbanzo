package week2;
import java.util.Scanner;

public class OperatorsSelectionStatements {

	public static void main(String[] args) {
//Ask the user for a decimal number
System.out.println("Please enter a decimal point number in the format xx.xxx eg. 12.345: ");
Scanner scanner = new Scanner(System.in);

//Store the value as a float
float decimalNumber = scanner.nextFloat();

System.out.printf("Number rounded (two decimal places)\t: \t%.2f\n",decimalNumber);
System.out.printf("Number squared (three decimal places)\t: \t%.3f\n",decimalNumber*decimalNumber);
System.out.printf("Number cubed to (three decimal places)\t: \t%.3f\n",Math.pow(decimalNumber, 2));
System.out.printf("Square Root (four decimal places)\t: \t%.4f",Math.sqrt(decimalNumber));
scanner.close();
	}
}
