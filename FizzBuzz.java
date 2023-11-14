/**
 * 
 */
package Revision;

/**
 * @author dmaccoille820
 * @version 30/10/2023
 */
public class FizzBuzz {

	/**
	 * @param args main method
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		FizzBuzz();
		// For loop 1-100
		for (int i = 1; i <= 100; i++) {
			
			// Check for multiples of 5 and 3
			if (i%3==0&&i%5==0) {
				System.out.println("Fizz, Buzz");
				Thread.sleep(400);
				continue;
			}
			// Check for multiples of 3
			else if(i%3==0) {
				System.out.println("Fizz");
				continue;
			}
			// Check for multiples of 5
			else if(i%5==0) {
				System.out.println("Buzz");
				continue;
			}
			// Print value of the counter
			else {System.out.println(i);}
		}

	}
	public static void FizzBuzz() {
		
		for (int i = 1; i <= 100; i++) {
		if (i % 3 == 0 && i % 5 == 0) {
		System.out.println("Fizz, Buzz");
		} else if (i % 3 == 0) {
		System.out.println("Fizz");
		} else if (i % 5 == 0) {
		System.out.println("Buzz");
		} else {
		System.out.println(i);
		}
		}
		}
		
}
