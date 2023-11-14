/**
 * 
 */
package week6_Arrays;

/**
 * @author Dara Mac Coille
 * @version 10/25/23
 */
public class ShopTillYouDrop {

	/**
	 * @param args for main method
	 */
	public static void main(String[] args) {

		// Print header
		System.out.println("Shopping Stats");

		int[][] customersData = { { 39, 45, 56, 78, 101, 45, 34, 34 }, { 31, 55, 56, 83, 121, 65, 31, 5 },
				{ 11, 45, 26, 23 }, { 34, 5, 50, 45, 67, 123, 121, 122, 89, 76 }, { 21, 25, 80, 25, 57, 73, 71, 62 },
				{ 1, 23, 56, 78, 56, 34, 78, 5 }, { 10, 43, 69, 98, 126, 134, 178, 75, 89, 90 } };

		totalCustomerDataForWeekDayByDay(customersData);
		displayEachDayWithTheTotalShoppingHours(customersData);
		displayTheAverageCustomerNumberPerHourForDay(customersData);
	}

	/**
	 * Total Customer Data For Week Day By Day
	 * 
	 * @param customersData a jagged array of customer shopping hours
	 */
	public static void totalCustomerDataForWeekDayByDay(int[][] customersData) {
		int totalCustomers = 0;
		int maxHours = 0;
		for (int row = 0; row < customersData.length; row++) {

			// 1.Display the total customer data for the week, day by day
			System.out.print("Day " + (row + 1) + " ");
			for (int col = 0; col < customersData[row].length; col++) {

				if (customersData[row][col] > maxHours) {
					maxHours = customersData[row][col];
				}
				System.out.print(customersData[row][col] + " ");

			}
			System.out.println();

		}
		
		
		// Collect the individual values from the int[][] and print the total
		for (int[] day : customersData) {
			for (int value : day) {
				totalCustomers += value;
			}
		}
		// 2.Display the total number of customers for the week
		System.out.println("Total customers :" + totalCustomers);
		
		// 3.Display the largest number of customers recorded during any hour of the week
		System.out.println("Highest customer numbers per hour : " + maxHours+"\n");
	}

	/**
	 * Display Each Day With The Total Shopping Hours
	 * 
	 * @param customersData a jagged array
	 */
	public static void displayEachDayWithTheTotalShoppingHours(int[][] customersData) {
		System.out.println("Day\tHours Total");
		for (int row = 0; row < customersData.length; row++) {

			// 4.Display each day with the total shopping hours (hours the shop was open
			// that day)
			System.out.println("Day " + (row + 1) + "\t" + customersData[row].length);
		}
	}

	
	/**
	 * Display the average customer number per hour for each day
	 * @param customersData a jagged array of customers shopping habits
	 */
	public static void displayTheAverageCustomerNumberPerHourForDay(int[][] customersData) {
		System.out.println("\nDay\tAverage customers per hour per day");
		for (int row = 0; row < customersData.length; row++) {
			double dayCustomerTotal = 0;
			double dayCustomerAverage = 0.0;
			for (int col = 0; col < customersData[row].length; col++) {
				int dayTotal = customersData[row].length;
				dayCustomerTotal += customersData[row][col];
				dayCustomerAverage = (dayCustomerTotal / dayTotal);
			} // inner loop end
			// 5.Display the average customer number per hour for day
			// (7 day week but the number of hours per day will vary)
			System.out.printf("Day " + (row + 1) + "\t %.2f%n", dayCustomerAverage);
		}// outer loop end
	}

}
