/**
 * 
 */
package com.leetcode.dp;

import java.util.Arrays;

/**
 * @author Manav
 * 
 *         Given a number n, find the lease number of perfect squares that sums
 *         to N
 *
 */
public class PerfectSquaresThatSumsToN {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int n = 1500;
		// int upperLimit = (int)Math.ceil(Math.sqrt(n));
		System.out.println(findLeastPerfectSquares(n));
	}

	public static int findLeastPerfectSquares(int n) {

		if (n <= 0) {
			return 0;
		}

		int[] dp = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);

		dp[0] = 0;
		dp[1] = 1;

		for (int i = 2; i <= n; i++) {
			for (int j = 1; j * j <= i; j++) {
				dp[i] = Math.min(dp[i], 1 + dp[i - j * j]);
			}
		}
		
		for (int i = 0; i <= n; i++) {
			System.out.print(dp[i] + " ");
		}
		System.out.println();
		return dp[n];
	}
}
