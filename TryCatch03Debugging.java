/**
 * 
 */
package tryCatch;

/**
 * @author Dara Mac Coille
 * @version Nov 14, 2023
 */
public class TryCatch03Debugging {

	/**
	 * @param args for main method
	 * Stepping through into over
	 * Put the breakpoint on lhs of a line, hit f11, check the variables window
	 * step over will run lines on the calling method
	 * step into will run lines of the method being called
	 * though use step filter -shift +f5 toggle menu, or window>preferences>java>debug>step filter
	 */
	public static void main(String[] args) {
		// Print the header and the division of 2 numbers
		
		System.out.println("Start");
		System.out.println(divUp(9,3));
		System.out.println("End");
		for (int i = 0; i < 10000000; i++) {
			System.out.println(i);
			if (i==9999999) {
				System.out.println("BREAK OUT");
				break;
			}
		}
	}

	private static int divUp(int i, int j) {
		// Create integer variable answer to hold the 
		// division  of 2 numbers
		int answer = i/j;
		return answer;
	}

}
