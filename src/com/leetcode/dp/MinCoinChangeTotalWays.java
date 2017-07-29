/**
 * 
 */
package com.leetcode.dp;

/**
 * @author Manav
 * 
 *         Given a value N, if we want to make change for N cents, and we have
 *         infinite supply of each of S = { S1, S2, .. , Sm} valued coins, how
 *         many ways can we make the change? The order of coins doesn’t matter.
 * 
 *         For example, for N = 4 and S = {1,2,3}, there are four solutions:
 *         {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4. For N = 10 and
 *         S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3},
 *         {2,2,6}, {2,3,5} and {5,5}. So the output should be 5.
 *
 */
public class MinCoinChangeTotalWays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] coins = new int[] { 2,5,3,6 };
		// Arrays.sort(coins);

		int N = 10;

		// to store the indices of the coins in the coin array
		int[] ways = new int[N + 1];
		
		// If value given is zero, there is only one way that you can
		// give a zero amount which is by not giving any coin
		ways[0] = 1;

		System.out.println(findTotalWays(coins, ways, N));

	}

	private static int findTotalWays(int[] coins, int[] ways, int n) {

		for (int i = 0; i < coins.length; i++) {

			for (int j = coins[i]; j < ways.length; j++) {
				ways[j] = ways[j] + ways[j - coins[i]];
			}
		}

		return ways[ways.length - 1];
	}

}
