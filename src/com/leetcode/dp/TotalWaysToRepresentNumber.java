/**
 * 
 */
package com.leetcode.dp;

/**
 * @author Manav
 * 
 * Given a number N, what are the total number of ways to represent it as sum of 1,3 and 4
 *
 */
public class TotalWaysToRepresentNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int n = 6;
		int[] nums = new int[] {1,3,4};
		
		System.out.println("Total Ways Using Recursion = " + findTotalWaysUsingRecursion(n, nums));
		
		System.out.println("Total Ways Using Dynamic Programming = " + findTotalWaysUsingDP(n, nums));
	}

	private static int findTotalWaysUsingDP(int n, int[] nums) {
		
		int[] dp = new int[n + 1];
		
		// Base Cases
		dp[0] = dp[1] = dp[2] = 1;
		dp[3] = 2;
		
		for (int i = 4; i <= n; i++) {
			for (int num : nums) {
				dp[i] += dp[i - num];
			}			
		}
		
		return dp[n];
	}

	private static int findTotalWaysUsingRecursion(int n, int[] nums) {
		
		if (n < 0) {
			return 0;
		} else if (n == 0) {
			return 1;
		}
		
		int totalWays = 0;
		
		for (int i = 0; i < nums.length; i++) {
			totalWays = totalWays + findTotalWaysUsingRecursion(n - nums[i], nums);
		}
		
		return totalWays;
	}

}
