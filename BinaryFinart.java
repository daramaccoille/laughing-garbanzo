/**
 * 
 */
package Revision;

/**
 * @author Dara Mac Coille
 * @version 30/10/2023
 */
public class BinaryFinart {

	/**
	 * @param args for main method
	 */
	public static void main(String[] args) {
		// Create boolean array for the numbers
		boolean[] eightBitArray = { true, false, false, 
				false, false, true, false, true };
		// Create int[] nums
		int[] nums= new int[8];
		for (int i = 0; i < eightBitArray.length; i++) {
			if (eightBitArray[i]==true) {
				nums[i]=1;	
			}
			else {
				nums[i]=0;
			}
		}
		for (int i : nums) {
			System.out.print(i);
		}
		System.out.println();
		System.out.println("Here's the int");
		System.out.println(totalEightBit(nums));
		}
	
static int totalEightBit(int[] nums) {
	int total=0;
	for (int i = nums.length-1; i >=0 ; i--) {
		switch (i) {
		case 7:
			if(nums[i]==1) {total+=Math.pow(2, nums.length-1-i);}break;
		case 6:
			if(nums[i]==1) {total+=Math.pow(2, nums.length-1-i);}break;
		case 5:
			if(nums[i]==1) {total+=Math.pow(2, nums.length-1-i);}break;
		case 4:
			if(nums[i]==1) {total+=Math.pow(2, nums.length-1-i);}break;
		case 3:
			if(nums[i]==1) {total+=Math.pow(2, nums.length-1-i);}break;
		case 2:
			if(nums[i]==1) {total+=Math.pow(2, nums.length-1-i);}break;
		case 1:
			if(nums[i]==1) {total+=Math.pow(2, nums.length-1-i);}break;
		case 0:
			if(nums[i]==1) {total+=Math.pow(2, nums.length-1-i);}break;
		default:
			total=0;;
		}
	}
	return total;
}
}
