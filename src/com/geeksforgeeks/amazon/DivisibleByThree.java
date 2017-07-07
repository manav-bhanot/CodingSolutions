/**
 * 
 */
package com.geeksforgeeks.amazon;

/**
 * @author Manav
 * 
 * Given an array of size N distinct numbers.
 * Find the number groups of sizes 2 or 3 such the sum of the numbers in the group is divisible by 2 or 3
 *
 */
public class DivisibleByThree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[] arr = new int[] {1,5,7,2,9,14};
		
		int totalGroups = findGroupsDivisibleByThree(arr);
		
		System.out.println(totalGroups);
	}

	private static int findGroupsDivisibleByThree(int[] arr) {
		
		int totalGroups = 0;
		
		// The groups array stores the counts of 3 different types of numbers
		// groups[0] -> stores the count of all those number which are exactly divisible by 3 and leaves a 0 remainder
		// groups[1] -> stores the count of all those numbers which leaves a remainder of 1 when divided by 3
		// groups[2] -> stores the count of all those numbers which leaves a remainder of 2 when divided by 3
		int[] groups = new int[3];
		
		for (int i=0; i < arr.length; i++) {
			int idx = arr[i] % 3;
			groups[idx]++;
		}
		
		// Now we have divided all the numbers into three different groups.
		// Lets see how are we going to create the total count of groups
		
		// Options of groups of 2
		// 1. All the numbers lying in groups[0] can be grouped in groups of 2
		// Let groups[0] = k => We have to find kC2 = (k * (k - 1)) / 2		
		totalGroups = totalGroups + (groups[0] * (groups[0] - 1) / 2);
		
		// 2. Total numbers in groups[1] and groups[2] can be combined with each other
		// to form of groups of 2 because each number from group[1] will combine with 
		// each number from group[2] and their sum will be divisible by 3
		totalGroups = totalGroups + (groups[1] * groups[2]);	
		
		// Now groups of three
		// Any three numbers whose remainders adds up to a multiple of 6 form valid groups
		totalGroups += ((groups[0]) * (groups[0] - 1) * (groups[0]  - 2)) / 6;
		totalGroups += ((groups[1]) * (groups[1] - 1) * (groups[1]  - 2)) / 6;
		totalGroups += ((groups[2]) * (groups[2] - 1) * (groups[2]  - 2)) / 6; 
		
		totalGroups += groups[0] * groups[1] * groups[2];
		
		return totalGroups;
	}
	
	

}
