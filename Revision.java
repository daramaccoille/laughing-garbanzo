/**
 * 
 */
package Revision;

import java.util.Arrays;

/**
 * @author Dara Mac Coille
 *
 */
public class Revision {

	/**
	 * @param args for main
	 */
	public static void main(String[] args) {
		int[] numbers = {100,200,300,400,500};
		int total =0;
		for (int number : numbers) {
			number+=100;
		}
		System.out.println(Arrays.toString(numbers));
		for (int number : numbers) {
			total+=number;
		}
		System.out.println(total);
//		int day=5;
//		String outputString;
//		switch (day) {
//		case 1:
//			outputString="Sun";
//			
//		case 2:
//			outputString="Mon";
//		case 3:
//			outputString="Tue";
//		case 4:
//			outputString="Wed";
//		case 5:
//			outputString="Thu";
//			break;
//		case 6:
//			outputString="Fri";
//		case 7:
//			outputString="Sat";
//			
//
//		default:
//			outputString="unknown";
//		}
		//System.out.println(outputString);
//		String[][] answers = new String[][] {{"Rock","Paper","Scissors"},{"R","P","S"}};
//		int[] numbs = new int[] {};
//		System.out.println(Arrays.deepToString(answers)+numbs);
//		int number =99;
//		System.out.println(++number);
//		double myPI =3.12435678;
//		String name="dara";
//		int tot = name.l
//		System.out.printf("%.4f",myPI);
		
		}
	public static double average(int[] data) {
        double averageresult = 0;
        int total = 0;
        for (int i = 0; i < data.length; i++) {
            total = total + data[i];
        }
        ;

        averageresult = (double) total / data.length;
        return averageresult;
    }

}
