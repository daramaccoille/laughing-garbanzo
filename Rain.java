/**
 * 
 */
package Revision;

import java.util.Arrays;

/**
 * @author Dara Mac Coille
 * @version 30/12/2023
 */
public class Rain {

	/**
	 * @param args for main method
	 */
	public static void main(String[] args) {
		// a 2D array for monthly rainfall data in mm per day in each month
		int[][] monthlyRainfall = {
				// January (31 days)
				{ 12, 8, 23, 4, 0, 9, 2, 3, 11, 14, 7, 18, 15, 1, 0, 2, 4, 0, 1, 1, 0, 0, 1, 0, 10, 3, 2, 0, 0, 0, 3 },
				// February (28 days)
				{ 3, 6, 9, 5, 7, 2, 4, 7, 6, 8, 7, 9, 0, 0, 0, 0, 0, 0, 0, 3, 1, 0, 2, 0, 9, 8, 0, 6 },
				// March (31 days)
				{ 1, 8, 0, 11, 8, 5, 7, 8, 4, 3, 7, 6, 5, 9, 0, 0, 0, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				// April (30 days)
				{ 3, 6, 5, 4, 8, 9, 6, 4, 3, 7, 6, 5, 8, 7, 6, 5, 9, 4, 0, 2, 0, 0, 2, 0, 0, 2, 0, 0, 0, 2 },
				// May (31 days)
				{ 2, 5, 8, 7, 6, 9, 8, 2, 7, 5, 3, 6, 8, 9, 4, 6, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2 },
				// June (30 days)
				{ 0, 6, 5, 8, 9, 6, 4, 7, 6, 5, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				// July (31 days)
				{ 1, 6, 0, 9, 7, 6, 5, 4, 8, 9, 6, 5, 7, 7, 4, 6, 8, 7, 5, 3, 7, 9, 8, 6, 5, 9, 0, 0, 2, 0, 0 },
				// August (31 days)
				{ 7, 6, 5, 8, 9, 6, 5, 4, 7, 6, 5, 9, 0, 0, 2, 0, 0, 0, 2, 0, 3, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0 },
				// September (30 days)
				{ 0, 0, 0, 1, 0, 0, 3, 0, 0, 0, 0, 0, 1, 9, 1, 1, 0, 0, 0, 0, 2, 3, 8, 0, 0, 0, 1, 1, 0, 0 },
				// October (31 days)
				{ 2, 5, 0, 0, 6, 0, 0, 0, 0, 5, 3, 0, 0, 0, 4, 6, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0 },
				// November (30 days)
				{ 7, 0, 5, 4, 8, 9, 6, 4, 3, 7, 6, 5, 8, 7, 6, 5, 9, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0 },
				// December (31 days)
				{ 2, 5, 8, 7, 6, 9, 8, 7, 5, 6, 3, 6, 9, 1, 2, 3, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 2, 0, 0, 1 } };
		printRainfallAnalysis(monthlyRainfall);
		heaviestDayRainTotal(monthlyRainfall);
		totalRainInYear(monthlyRainfall);
		rainfallAverageInYear(monthlyRainfall);
		totalDaysRainPerMonth(monthlyRainfall);
		monthWithMostRainByVolume(monthlyRainfall);
		rainVisualMmOfRainOnWetDays(monthlyRainfall);
	}
/**
 * monthInLetters takes an integer, starting at 0, and equates this 
 * to a three letter String of month e.g. 0="Jan", 1="Feb"
 * @param position is the position of the sending array
 * @return the three letter String month
 */
	public static String monthInLetters(int position) {
		switch (position) {
		case 0:
			return "Jan";
		case 1:
			return "Feb";
		case 2:
			return "Mar";
		case 3:
			return "Apr";
		case 4:
			return "May";
		case 5:
			return "Jun";
		case 6:
			return "Jul";
		case 7:
			return "Aug";
		case 8:
			return "Sep";
		case 9:
			return "Oct";
		case 10:
			return "Nov";
		case 11:
			return "Dec";
		default:
			return "Unexpected value: " + position;
		}
	}

	/**
	 *  Method to print the rainfall analysis
	 * @param yearsData is the 2D integer array of rainfall
	 */
	public static void printRainfallAnalysis(int[][] yearsData) {
		// Print header
		System.out.println("Rainfall Analysis");
		System.out.println("All Rainfall per month (mm)");
		// Loop through each month
		for (int i = 0; i < yearsData.length; i++) {
			System.out.print(monthInLetters(i) + " ");
			// Loop through each day
			for (int j = 0; j < yearsData[i].length; j++) {
				System.out.print(yearsData[i][j] + " ");
			}
			System.out.println();
		}
	}
	/**
	 * Method to print the heaviesr Day Rain total
	 * @param yearsData is the 2D integer array of rainfall
	 */
	public static void heaviestDayRainTotal(int[][] yearsData) {
		int max = -1;
		System.out.print("Heaviest Day Rain Total : ");
		for (int i = 0; i < yearsData.length; i++) {
			for (int j = 0; j < yearsData[i].length; j++) {
				if (yearsData[i][j] > max) {
					max = yearsData[i][j];
				}
			}
		}
		System.out.print(max + " (mm)\n");
	}
/**
 * Method to print the total rain in the year
 * @param yearsData is the 2D integer array of rainfall
 */
	public static void totalRainInYear(int[][] yearsData) {
		int total = 0;
		System.out.print("Total of rain in year : ");
		for (int i = 0; i < yearsData.length; i++) {
			for (int j = 0; j < yearsData[i].length; j++) {
				total += yearsData[i][j];
				{

				}
				;
			}
		}
		System.out.print(total + " (mm)\n");
	}

	public static void rainfallAverageInYear(int[][] yearsData) {
		int total = 0;
		int count = 0;

		System.out.print("Total of rain in year : ");
		for (int i = 0; i < yearsData.length; i++) {
			for (int j = 0; j < yearsData[i].length; j++) {
				total += yearsData[i][j];
				{
					count++;
				}
				;
			}
		}
		System.out.printf("%.2f (mm)", (double) (total / (double) count));
	}

	public static void totalDaysRainPerMonth(int[][] yearsData) {

		System.out.print("Total days rain per month (mm)\n");
		for (int i = 0; i < yearsData.length; i++) {
			System.out.print(monthInLetters(i) + " ");
			int totalDays = 0;
			for (int j = 0; j < yearsData[i].length; j++) {

				if (yearsData[i][j] > 0) {
					totalDays += 1;
				}
			}
			System.out.print(totalDays + "\n");
		}
	}

	/**
	 * monthWithMostRainByVolume will print the
	 * Month with most rain by volume 
	 * @param yearsData is the 2d array of data
	 */
	public static void monthWithMostRainByVolume(int[][] yearsData) {

		System.out.print("Month with most rain by volume : ");

		int maxRainVolume = 0;
		int month = -1;
		for (int i = 0; i < yearsData.length; i++) {

			int rainByVolume = 0;
			for (int j = 0; j < yearsData[i].length; j++) {

				rainByVolume += yearsData[i][j];

			}
			if (rainByVolume > maxRainVolume) {
				maxRainVolume = rainByVolume;
				month = i;
			}
			;
		}
		System.out.print(monthInLetters(month));
	}

	/**
	 * rainVisualMmOfRainOnWetDays will take the 2d array of years
	 * data and print a table of the months data with wet days sorted
	 * @param yearsData is the 2d array
	 */
	public static void rainVisualMmOfRainOnWetDays(int[][] yearsData) {
		System.out.println("\n\nRain visual - mm of rain on wet days sorted (asc)");
		for (int i = 0; i < yearsData.length; i++) {
			System.out.print(monthInLetters(i) + " \t");
			printSortedIntArray(yearsData[i]);
		}
	}

	/**
	 * printSortedIntArray will sort the array of values greater than 0
	 * @param unsorted array of month data for sorting
	 */
	public static void printSortedIntArray(int[] unsorted) {
		// int[] previouslyUnsorted = Arrays.copyOf(unsorted, unsorted.length);

		Arrays.sort(unsorted);
		for (int i : unsorted) {
			if (i > 0) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
	}
}
