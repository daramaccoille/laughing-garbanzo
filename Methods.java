/**
 * 
 */
package Methods;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * @author dmaccoille820
 * @version 10/10/23
 */
public class Methods {

	/**
	 * @param args for main
	 * @throws InterruptedException 
	 */
	public static void main(String[] args)throws Exception{
		// TODO Auto-generated method stub
		MyMethodinMethodClass(5,6);
		System.out.println("Enter your name: ");
		MyName(10);
		System.out.println("You will turn 100 in the year "+YearAged100(50));
		WeekOfTheYear();
		AreaOfCircle(9);
		AreaOfTriangle(3,4);
		//Countdown(3);
		//TheInbetweeners(2,5);
		min(13,17);
		average(75,47,80,93);
	}
	/**
	 * Adding 2 numbers together
	 * @param number1
	 * @param number2
	 */
	public static void MyMethodinMethodClass(int number1, int number2) {
		System.out.println(number1+number2);
	}
	/**
	 * MyName method to link with scanner in main to print out a name
	 * @param times The amount of times to print the name
	 * @return
	 */
	public static void MyName(int times) {
		Scanner scanner = new Scanner(System.in);
		String name = scanner.next();
		for (int i = 0; i < times; i++) {
			System.out.println("My name is "+name);
		}
		scanner.close();
	}
	/**
	 * 
	 * @param age
	 * @return an integer to show the years till aged 100
	 */
	public static int YearAged100(int age) {
		return 100-age + java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
	}
	/**
	 * works out the current week in the year
	 */
	public static void WeekOfTheYear() {
		int week = java.util.Calendar.getInstance().get(java.util.Calendar.WEEK_OF_YEAR);
		System.out.println("The week is "+ week);
	}
	/**
	 * superscript 2 is \u00b2
	 * @param radius of the circle to calculate area
	 */
	//static final double pi = 3.14; MATH.pi better
	public static void AreaOfCircle(float radius) {
		System.out.printf("The area of the "+radius+"cm circle is %.2fcm\u00b2\n",Math.pow(radius, 2)*Math.PI);
		
	}
	/**
	 * 
	 * @param length
	 * @param height
	 * superscript 2 is \u00b2
	 */
	public static void AreaOfTriangle(double length, double height) {
		double area = (length*height)/2;
		System.out.println("The area of the right angled triangle of "+length+"x"+height+" is "+area+"cm\u00b2\n");
		
	}
	/**
	 * 'Count_down' tries to count down to 0 from the initial value
	 * @param startVal
	 * @throws Exception
	 */
	public static void Countdown(int startVal)throws Exception {
		for (int i = startVal; i > 0; i--) {
			System.out.println(i);
			TimeUnit.SECONDS.sleep(1);
		}
		System.out.println("Countdown Done");
	}
	/**
	 * The 'InBetweeners counts up from a starting value to the end
	 * @param start
	 * @param end
	 */
	public static void TheInbetweeners(int start, int end) throws Exception {
		for (int i = start; i <= end; i++) {
			System.out.println(i);
			TimeUnit.SECONDS.sleep(1);
		}
		System.out.println("Inbetweeners Done");
	}
	/**
	 * 'min' attempts to print out the max value of two input integers
	 * @param num1
	 * @param num2
	 */
	public static void min(int num1, int num2) {
		if (num1>num2) {
			System.out.println(num1 +" is greater than "+num2);
		}
		else if (num2>num1) {
			System.out.println(num2 +" is greater than "+num1);
		}
		else {System.out.println("The numbers are likely the same");}
	}
	/**
	 * 'average' attempts to print out the average value of two input integers
	 * @param num1
	 * @param num2
	 */
	public static void average(int num1, int num2,int num3, int num4) {
		double average = (double)(num1+num2+num3+num4)/4;
		System.out.println("The average age expectancy of "+num1+", "+num2+", "
				+num3+", "+num4+" is "+average);
	}
}
