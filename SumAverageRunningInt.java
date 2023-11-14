/**
 * 
 */
package week6_reading;

/**
 * @author Dara Mac Coille
 * @version Nov 4, 2023
 * SumAverageRunningInt  sums and averages the numbers from 1 to 100 inclusive
 * The sum of 1 to 100 is 5050
* The average is 50.5
 */
public class SumAverageRunningInt {

	/**
	 * @param args for main
	 */
	public static void main(String[] args) {
		int lowerBound = 111;
		int upperBound=8899;
		int oddSum =0;
		int evenSum =0;
//		for (int i = lowerBound; i <= upperBound; i++) {
//			sum+=i;
//		}
		while (lowerBound<upperBound) {
			if (lowerBound%2==0) {
				evenSum+=lowerBound;
				lowerBound++;
			}
			else{oddSum+=lowerBound;
			lowerBound++;}
			//sum+=Math.pow(lowerBound, lowerBound);
		}
System.out.println("The Odd sum of 1 to 100 is : "+oddSum);
System.out.println("The even sum of 1 to 100 is : "+evenSum);
System.out.println("The absolute difference of odd and even sums from 1 to 100 is : "+ Math.abs(oddSum-evenSum));

//System.out.printf("The average is : %.2f", (double)sum/upperBound);
	}

}
