/**
 * 
 */
package com.leetcode;

/**
 * @author Manav
 *         A man is walking up a set of stairs. He can either take 1 or 2
 *         steps at a time. Given n number of steps, find out how many
 *         combinations of steps he can take to reach the top of the stairs.
 */
public class TotalWaysToClimbStaircase {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(countSteps(10));
	}
	
	public static int countSteps(int n) {
		
		int[] ways = new int[n + 1];
		// Assuming steps[0] is the ground level
		ways[0] = 0;
		ways[1] = 1;
		ways[2] = 2;
		
		for (int i = 3; i < n + 1; i++) {
			ways[i] = ways[i-1] + ways[i-2];
		}
		
		return ways[ways.length - 1];
	}

}
